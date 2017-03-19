package br.com.mobiplus.simplerecylerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import br.com.mobiplus.simplerecylerview.annotations.ImageAdapter;
import br.com.mobiplus.simplerecylerview.annotations.LayoutAdapter;
import br.com.mobiplus.simplerecylerview.annotations.TextAdapter;
import br.com.mobiplus.simplerecylerview.util.TypefaceUtil;

/**
 * Created by luisfernandez on 2/10/16.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private Context mContext;
    private int mLayoutResId;
    private int[] mArrayClickableResIds;
    private List mList;
    private OnItemClickListener mOnItemClickListener;
    private OnPreloadContent onPreloadContent;

    public CustomAdapter(Context context, List list, OnItemClickListener onItemClickListener) {
        this.mContext = context;
        this.mList = list;
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Object obj = mList.get(0);
        Class clazz = obj.getClass();
        LayoutAdapter layoutAdapter = (LayoutAdapter) clazz.getAnnotation(LayoutAdapter.class);
        mLayoutResId = layoutAdapter.layoutResId();
        mArrayClickableResIds = layoutAdapter.arrayClickableResIds();
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutResId, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.bind(position, mOnItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addOnPreloadContent(OnPreloadContent onPreloadContent) {
        this.onPreloadContent = onPreloadContent;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private Object mCurrentItem;

        public CustomViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(int position, final OnItemClickListener onItemClickListener) {
            mCurrentItem = mList.get(position);
            Method[] declaredMethods = mCurrentItem.getClass().getDeclaredMethods();

            if (mArrayClickableResIds.length > 0) {
                for (int i = 0; i < mArrayClickableResIds.length; i++) {
                    int clickableResId = mArrayClickableResIds[i];
                    View clickableView = itemView.findViewById(clickableResId);
                    clickableView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (onItemClickListener != null) {
                                //noinspection unchecked
                                onItemClickListener.onItemClick(mCurrentItem, v.getId());
                            }
                        }
                    });
                }
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        //noinspection unchecked
                        onItemClickListener.onItemClick(mCurrentItem, v.getId());
                    }
                }
            });

            for (int i = 0; i < declaredMethods.length; i++) {
                Method declaredMethod = declaredMethods[i];

                Annotation[] annotations = declaredMethod.getAnnotations();

                for (int j = 0; j < annotations.length; j++) {
                    Annotation annotation = annotations[j];

                    if (annotation instanceof TextAdapter) {
                        int resId = ((TextAdapter) annotation).resId();
                        String typeface = ((TextAdapter) annotation).typeface();
                        //noinspection TryWithIdenticalCatches
                        try {
                            String textContent = String.valueOf(declaredMethod.invoke(mCurrentItem));
                            TextView textView = (TextView) itemView.findViewById(resId);

                            if (onPreloadContent == null || !onPreloadContent.onPreLoadContent(textContent, textView)) {
                                if (!TextUtils.isEmpty(typeface)) {
                                    TypefaceUtil.defineTextStyle(mContext, textView, typeface);
                                }

                                textView.setText(textContent);
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }

                    if (annotation instanceof ImageAdapter) {
                        int resId = ((ImageAdapter) annotation).resId();

                        //noinspection TryWithIdenticalCatches
                        try {
                            String imageUrl = (String) declaredMethod.invoke(mCurrentItem);
                            ImageView imageView = (ImageView) itemView.findViewById(resId);
                            Picasso.with(mContext).load(imageUrl).into(imageView);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
