/*
 * Created by Antonio Lozano on 2/20/2020.
 */

package mx.com.retrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import mx.com.retrofit.R;
import mx.com.retrofit.model.RetroPhoto;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>
{
    private List<RetroPhoto> mMovieList;
    private Context mContext;

    public CustomAdapter (final Context context, final List<RetroPhoto> movieList)
    {
        mContext = context;
        mMovieList = movieList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder
    {
        public final View mView;
        TextView mTextView;
        private ImageView mCoverImage;

        CustomViewHolder(final View itemView)
        {
            super(itemView);
            mView = itemView;

            mTextView = mView.findViewById(R.id.title);
            mCoverImage = mView.findViewById(R.id.coverImage);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from((parent.getContext()));
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull final CustomViewHolder holder,
            final int position)
    {
        holder.mTextView.setText(mMovieList.get(position).getTitle());

        Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.downloader(new OkHttp3Downloader(mContext));
        builder.build().load(mMovieList.get(position).getThumbnailUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.mCoverImage);
    }

    @Override
    public int getItemCount()
    {
        return mMovieList.size();
    }
}
