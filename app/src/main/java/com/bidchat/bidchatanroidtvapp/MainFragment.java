package com.bidchat.bidchatanroidtvapp;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v17.leanback.app.BrowseFragment;

import com.bidchat.bidchatanroidtvapp.Framework.BaseActivity;
import com.bidchat.bidchatanroidtvapp.Model.Broadcast;
import com.bidchat.bidchatanroidtvapp.presenter.CardPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends BrowseFragment {
    private static final String TAG = MainFragment.class.getSimpleName();
    private ArrayObjectAdapter mRowsAdapter;
    private static final int GRID_ITEM_WIDTH = 300;
    private static final int GRID_ITEM_HEIGHT = 200;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);


        setupUIElements();
        fetchAllBroadcast();
//        loadRowsForCards();
    }

    private void setupUIElements() {
        // setBadgeDrawable(getActivity().getResources().getDrawable(R.drawable.videos_by_google_banner));
        setTitle("Hello Android TV!"); // Badge, when set, takes precedent
        // over title
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);

        // set fastLane (or headers) background color
        setBrandColor(getResources().getColor(R.color.fastlane_background));
        // set search icon color
        setSearchAffordanceColor(getResources().getColor(R.color.search_opaque));
    }

    private void loadRowsForCards()
    {
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        /* CardPresenter */
        HeaderItem cardPresenterHeader = new HeaderItem(1, "CardPresenter");
        CardPresenter cardPresenter = new CardPresenter();
        ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);

        for(int i=0; i<10; i++) {
            Broadcast broadcast = new Broadcast();
            broadcast.setHash_tag1("title" + i);
            broadcast.setHash_tag2("studio" + i);
            cardRowAdapter.add(broadcast);
        }
        mRowsAdapter.add(new ListRow(cardPresenterHeader, cardRowAdapter));
        setAdapter(mRowsAdapter);
    }

    private void loadRows() {
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        /* GridItemPresenter */
        HeaderItem gridItemPresenterHeader = new HeaderItem(0, "GridItemPresenter");

        GridItemPresenter mGridPresenter = new GridItemPresenter();
        ArrayObjectAdapter gridRowAdapter = new ArrayObjectAdapter(mGridPresenter);
        gridRowAdapter.clear();
        for (Broadcast broadcast:allBroadcast) {
            gridRowAdapter.add(broadcast);
        }
        mRowsAdapter.add(new ListRow(gridItemPresenterHeader, gridRowAdapter));

        /* set */
        setAdapter(mRowsAdapter);
    }

    private class GridItemPresenter extends Presenter {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent) {
            TextView view = new TextView(parent.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT));
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setBackgroundColor(getResources().getColor(R.color.default_background));
            view.setTextColor(Color.WHITE);
            view.setGravity(Gravity.CENTER);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Object item) {
            Broadcast bItem = (Broadcast) item;
            ((TextView) viewHolder.view).setText(bItem.getHash_tag1() + bItem.getHash_tag2());
        }

        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {

        }
    }


    List<Broadcast> allBroadcast;
    public void fetchAllBroadcast() {
        Call<List<Broadcast>> fetchBroadcast = ((BaseActivity)getActivity()).getBidApplication().getAPIService().listBroadcast();
        ((BaseActivity)getActivity()).showProgressBar("Please wait");
        fetchBroadcast.enqueue(new Callback<List<Broadcast>>() {
            @Override
            public void onResponse(Call<List<Broadcast>> call, Response<List<Broadcast>> response) {
                ((BaseActivity)getActivity()).hideProgressBar();
                setDataToAdapter(response.body());
            }

            @Override
            public void onFailure(Call<List<Broadcast>> call, Throwable t) {
                ((BaseActivity)getActivity()).hideProgressBar();
                ((BaseActivity)getActivity()).showInDailog("Error while making the calls", "Error");
            }
        });
    }

    public void setDataToAdapter(List<Broadcast> body)
    {
        allBroadcast = body;
        loadRows();
    }
}
