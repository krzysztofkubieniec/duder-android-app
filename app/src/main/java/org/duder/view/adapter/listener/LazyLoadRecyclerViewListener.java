package org.duder.view.adapter.listener;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class LazyLoadRecyclerViewListener extends RecyclerView.OnScrollListener {
    private static final int VISIBLE_THRESHOLD = 3; //Number of items left in list before we start loading more
    private LinearLayoutManager layoutManager;
    private boolean isLoading = false;
    private boolean isOnBottom = false;

    public LazyLoadRecyclerViewListener(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    protected abstract void onLoadMore();

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (shouldFetchMoreItems(layoutManager, recyclerView)) {
            onLoadMore();
            isLoading = true;
            if (hasReachedBottom(recyclerView)) {
                isOnBottom = true;
            }
        }
        if (!hasReachedBottom(recyclerView)) {
            isOnBottom = false;
        }
    }

    private boolean shouldFetchMoreItems(LinearLayoutManager layoutManager, RecyclerView recyclerView) {
        int visibleItemCount = recyclerView.getChildCount();
        int totalItemCount = layoutManager.getItemCount();
        int firstVisibleItem = layoutManager.findFirstVisibleItemPosition();

        return !isLoading
                && (totalItemCount - visibleItemCount == firstVisibleItem + VISIBLE_THRESHOLD
                || hasReachedBottom(recyclerView));
    }

    private boolean hasReachedBottom(RecyclerView recyclerView) {
        return !recyclerView.canScrollVertically(1);

    }

    public void setLoading(boolean loading) {
        this.isLoading = loading;
    }
}
