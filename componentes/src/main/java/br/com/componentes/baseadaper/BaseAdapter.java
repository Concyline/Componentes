package br.com.componentes.baseadaper;

import android.content.res.Resources;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

import br.com.componentes.R;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.ClickableViewHolder> {

    private final List<T> mData;
    private int[] ids;

    private final OnViewHolderClickListener mItemClickListener;

    abstract protected int getItemView();

    public BaseAdapter(@NonNull final List<T> data) {
        this(data, null);
    }

    public BaseAdapter(@NonNull final List<T> data, @Nullable final OnViewHolderClickListener itemClickListener) {
        this.mData = data;
        this.mItemClickListener = itemClickListener;
    }

    public final T getItem(int position) {
        return this.mData.get(position);
    }

    @Override
    public final int getItemCount() {
        return mData.size();
    }

    @Override
    public final ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(getItemView(), parent, false);

        if(ids == null) {
            ids = getAllChildren(view);
        }

        return new ClickableViewHolder(view, mItemClickListener, ids);
    }


    private int[] getAllChildren(View v) {

        List<Integer> visited = new ArrayList<>();
        List<View> unvisited = new ArrayList<>();
        unvisited.add(v);

        while (!unvisited.isEmpty()) {

            View child = unvisited.remove(0);
            if (child.getId() != -1) {
                visited.add(child.getId());
            }

            if (!(child instanceof ViewGroup)) {
                continue;
            }

            ViewGroup group = (ViewGroup) child;
            final int childCount = group.getChildCount();

            for (int i = 0; i < childCount; i++) {
                unvisited.add(group.getChildAt(i));
            }
        }

        int[] ids = new int[visited.size()];

        for (int i = 0; i < visited.size(); i++) {
            ids[i] = visited.get(i);
        }

        return ids;
    }

    public static class ClickableViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        boolean longClick = false;
        private final OnViewHolderClickListener mItemClickListener;

        private SparseArray<View> mInflatedViewsMap;

        public ClickableViewHolder(@NonNull View itemView, @Nullable OnViewHolderClickListener itemClickListener, @Nullable final int[] resIdOfInflatedViews) {
            super(itemView);

            this.mItemClickListener = itemClickListener;
            if (itemClickListener != null) {
                itemView.setOnClickListener(this);
                itemView.setOnLongClickListener(this);
            }
            initViews(resIdOfInflatedViews);
        }

        private void initViews(@Nullable final int[] resIdOfInflatedViews) {

            if (resIdOfInflatedViews != null) {
                mInflatedViewsMap = new SparseArray<>(0);
                for (Integer viewId : resIdOfInflatedViews) {
                    mInflatedViewsMap.put(viewId, itemView.findViewById(viewId));
                }
            }
        }

        public View getViewById(@IdRes int viewId) {
            final View view = mInflatedViewsMap.get(viewId);
            if (view == null) {
                throw new Resources.NotFoundException("View is not associated with this layout");
            }
            return view;
        }

        @Override
        public void onClick(View v) {
            if (!longClick && mItemClickListener != null) {
                mItemClickListener.onClickListener(getAdapterPosition());
            }

            longClick = false;
        }

        @Override
        public boolean onLongClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onLongClickListener(getAdapterPosition());
            }

            longClick = true;
            return false;
        }


    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////

    public static GridLayoutManager getGridLayoutManager(AppCompatActivity appCompatActivity) {
        return getGridLayoutManager(appCompatActivity, 1);
    }

    public static GridLayoutManager getGridLayoutManager(AppCompatActivity appCompatActivity, @Nullable int coluns) {
        return new GridLayoutManager(appCompatActivity, coluns);
    }

    public static LinearLayoutManager getLinearLayoutManager(AppCompatActivity appCompatActivity, int orientation) {
        return new LinearLayoutManager(appCompatActivity, orientation, false);
    }

    public static DividerItemDecoration getDividerItemDecoration(AppCompatActivity appCompatActivity, int orientation) {
        return new DividerItemDecoration(appCompatActivity, orientation);
    }


}
