package mx.com.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import mx.com.retrofit.adapter.CustomAdapter;
import mx.com.retrofit.model.IGetDataService;
import mx.com.retrofit.model.RetroPhoto;
import mx.com.retrofit.network.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity
        extends AppCompatActivity
{

    private CustomAdapter mCustomAdapter;
    private RecyclerView mRecyclerView;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage(getResources().getString(R.string.loading));
        mProgressDialog.show();

        getPhotos();
    }

    private void getPhotos()
    {
        // Create handle for the Retrofit Instance interface
        IGetDataService service =
                RetrofitClientInstance.getInstance().create(IGetDataService.class);

        Call<List<RetroPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>()
        {
            @Override
            public void onResponse(
                    final Call<List<RetroPhoto>> call,
                    final Response<List<RetroPhoto>> response)
            {
                mProgressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(
                    Call<List<RetroPhoto>> call,
                    Throwable t)
            {
                mProgressDialog.dismiss();
                Toast.makeText(
                        MainActivity.this,
                        getResources().getString(R.string.response_error),
                        Toast.LENGTH_LONG).show();

            }
        });
    }

    private void generateDataList(final List<RetroPhoto> photoList)
    {
        mRecyclerView = findViewById(R.id.customRecyclerView);
        mCustomAdapter = new CustomAdapter(this, photoList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mCustomAdapter);
    }
}
