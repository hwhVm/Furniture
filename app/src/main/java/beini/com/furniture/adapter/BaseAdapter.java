package beini.com.furniture.adapter;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import beini.com.furniture.bean.BaseBean;


/**
 * Created by beini on 2017/2/18
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {

    private List<T> baseLit;
    private int layoutId;

    public BaseAdapter(List<T> baseLit) {
        this.baseLit = baseLit;
    }

    public BaseAdapter(@NonNull BaseBean<T> baseBean) {
        this.baseLit = baseBean.getBaseList();
        this.layoutId = baseBean.getId();
    }

    public BaseAdapter(@NonNull BaseBean<T> baseBean, OnItemClickListener listener) {
        this.baseLit = baseBean.getBaseList();
        this.layoutId = baseBean.getId();
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return holder;
    }

    @Override
    public int getItemCount() {
        if (baseLit == null || baseLit.size() == 0) {
            return 0;
        }
        return baseLit.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
        }
    }

    public ViewGroup getViewGroup(@NonNull ViewHolder holder, @IdRes int viewId) {
        return (ViewGroup) holder.view.findViewById(viewId);
    }

    public TextView getTextView(@NonNull ViewHolder holder, @IdRes int viewId) {
        return (TextView) holder.view.findViewById(viewId);
    }

    public ImageView getImageView(@NonNull ViewHolder holder, @IdRes int viewId) {
        return (ImageView) holder.view.findViewById(viewId);
    }
    
    public View getView(@NonNull ViewHolder holder, @IdRes int viewId) {
        return holder.view.findViewById(viewId);
    }

    public LinearLayout getLinearLayout(@NonNull ViewHolder holder, @IdRes int viewId) {
        return (LinearLayout) holder.view.findViewById(viewId);
    }

    //item  click 事件
    private OnItemClickListener itemClickListener = null;

    public void setItemClick(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        if (itemClickListener != null)
            itemClickListener.onItemClick(view, (int) view.getTag());
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    // item onlongClick 事件
    private onItemLongClickListener itemLongClickListener = null;

    public void setOnItemLongClickListener(onItemLongClickListener onItemLongClickListener) {
        this.itemLongClickListener = onItemLongClickListener;
    }

    @Override
    public boolean onLongClick(View v) {
        if (itemLongClickListener != null)
            itemLongClickListener.onItemLongClick(v, (int) v.getTag());
        return true;
    }

    public interface onItemLongClickListener {
        void onItemLongClick(View view, int position);
    }
}
