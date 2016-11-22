package com.bidchat.bidchatanroidtvapp.Model;

/**
 * Created by RahulV on 05-10-2016.
 */

public class Broadcast
{
    private String is_user_active;

    private String likes_count;

    private String hash_tag2;

    private String hash_tag1;

    private String lowres_video_url;

    private String date;

    private String id;

    private String first_name;

    private String username;

    private String is_poi_active;

    private String video_url;

    private String last_name;

    private String video_length;

    private String embed_key;

    private String view_count;

    private String video_thumb_url;

    public String getIs_user_active ()
    {
        return is_user_active;
    }

    public void setIs_user_active (String is_user_active)
    {
        this.is_user_active = is_user_active;
    }

    public String getLikes_count ()
    {
        return likes_count;
    }

    public void setLikes_count (String likes_count)
    {
        this.likes_count = likes_count;
    }

    public String getHash_tag2 ()
    {
        return hash_tag2;
    }

    public void setHash_tag2 (String hash_tag2)
    {
        this.hash_tag2 = hash_tag2;
    }

    public String getHash_tag1 ()
    {
        return hash_tag1;
    }

    public void setHash_tag1 (String hash_tag1)
    {
        this.hash_tag1 = hash_tag1;
    }

    public String getLowres_video_url ()
    {
        return lowres_video_url;
    }

    public void setLowres_video_url (String lowres_video_url)
    {
        this.lowres_video_url = lowres_video_url;
    }

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getFirst_name ()
    {
        return first_name;
    }

    public void setFirst_name (String first_name)
    {
        this.first_name = first_name;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public String getIs_poi_active ()
    {
        return is_poi_active;
    }

    public void setIs_poi_active (String is_poi_active)
    {
        this.is_poi_active = is_poi_active;
    }

    public String getVideo_url ()
    {
        return video_url;
    }

    public void setVideo_url (String video_url)
    {
        this.video_url = video_url;
    }

    public String getLast_name ()
    {
        return last_name;
    }

    public void setLast_name (String last_name)
    {
        this.last_name = last_name;
    }

    public String getVideo_length ()
    {
        return video_length;
    }

    public void setVideo_length (String video_length)
    {
        this.video_length = video_length;
    }

    public String getEmbed_key ()
    {
        return embed_key;
    }

    public void setEmbed_key (String embed_key)
    {
        this.embed_key = embed_key;
    }

    public String getView_count ()
    {
        return view_count;
    }

    public void setView_count (String view_count)
    {
        this.view_count = view_count;
    }

    public String getVideo_thumb_url ()
    {
        return video_thumb_url;
    }

    public void setVideo_thumb_url (String video_thumb_url)
    {
        this.video_thumb_url = video_thumb_url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [is_user_active = "+is_user_active+", likes_count = "+likes_count+", hash_tag2 = "+hash_tag2+", hash_tag1 = "+hash_tag1+", lowres_video_url = "+lowres_video_url+", date = "+date+", id = "+id+", first_name = "+first_name+", username = "+username+", is_poi_active = "+is_poi_active+", video_url = "+video_url+", last_name = "+last_name+", video_length = "+video_length+", embed_key = "+embed_key+", view_count = "+view_count+", video_thumb_url = "+video_thumb_url+"]";
    }
}