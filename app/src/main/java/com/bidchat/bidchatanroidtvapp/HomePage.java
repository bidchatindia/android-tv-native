package com.bidchat.bidchatanroidtvapp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bidchat.bidchatanroidtvapp.Framework.BaseActivity;
import com.bidchat.bidchatanroidtvapp.Model.Broadcast;
import com.bidchat.bidchatanroidtvapp.adapter.BroadcastAdapter;
import com.longtailvideo.jwplayer.JWPlayerView;
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePage extends BaseActivity {

    @Bind(R.id.rv_broadcast)
    RecyclerView rvBroadcast;
    JWPlayerView jwPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_base);
        rvBroadcast = (RecyclerView) findViewById(R.id.rv_broadcast);
        jwPlayerView = (JWPlayerView) findViewById(R.id.jw_homeplayer);
        PlaylistItem pi = new PlaylistItem.Builder()
                .file("http://playertest.longtailvideo.com/adaptive/bipbop/gear4/prog_index.m3u8")
                .title("BipBop")
                .description("A video player testing video.")
                .build();
        jwPlayerView.load(pi);
        fetchAllBroadcast();
    }

    public void fetchAllBroadcast() {
        Call<List<Broadcast>> fetchBroadcast = getBidApplication().getAPIService().listBroadcast();
        showProgressBar("Please wait");
        fetchBroadcast.enqueue(new Callback<List<Broadcast>>() {
            @Override
            public void onResponse(Call<List<Broadcast>> call, Response<List<Broadcast>> response) {
                hideProgressBar();
                setDataToAdapter(response.body());
            }

            @Override
            public void onFailure(Call<List<Broadcast>> call, Throwable t) {
                hideProgressBar();
                showInDailog("Error while making the calls", "Error");
            }
        });
    }


    public void setDataToAdapter(List<Broadcast> broadcasts)
    {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomePage.this, LinearLayoutManager.HORIZONTAL, false);
        rvBroadcast.setLayoutManager(linearLayoutManager);
        BroadcastAdapter adapter = new BroadcastAdapter(HomePage.this, broadcasts, new BroadcastAdapter.BroadcastiewHolderListener() {
            @Override
            public void onChildClicked(Broadcast broadcast) {
                PlaylistItem pi = new PlaylistItem.Builder()
                        .file(broadcast.getVideo_url())
                        .title(broadcast.getUsername())
                        .description(broadcast.getHash_tag1() + broadcast.getHash_tag2())
                        .build();
                jwPlayerView.load(pi);
            }
        });
        rvBroadcast.setAdapter(adapter);
    }

}
