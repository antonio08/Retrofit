/*
 * Created by Antonio Lozano on 2/20/2020.
 */

package mx.com.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class RetroPhoto
{
    @SerializedName("albumId")
    private Integer mAlbumId;

    @SerializedName("id")
    private Integer mId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("thumbnailUrl")
    private String mThumbnailUrl;

    public RetroPhoto(
            final Integer albumId,
            final Integer id,
            final String title,
            final String url,
            final String thumbnailUrl)
    {
        mAlbumId = albumId;
        mId = id;
        mTitle = title;
        mUrl = url;
        mThumbnailUrl = thumbnailUrl;
    }

    public Integer getAlbumId()
    {
        return mAlbumId;
    }

    public void setAlbumId(Integer albumId)
    {
        mAlbumId = albumId;
    }

    public Integer getId()
    {
        return mId;
    }

    public void setId(Integer id)
    {
        mId = id;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public void setTitle(String title)
    {
        mTitle = title;
    }

    public String getUrl()
    {
        return mUrl;
    }

    public void setUrl(String url)
    {
        mUrl = url;
    }

    public String getThumbnailUrl()
    {
        return mThumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl)
    {
        mThumbnailUrl = thumbnailUrl;
    }
}
