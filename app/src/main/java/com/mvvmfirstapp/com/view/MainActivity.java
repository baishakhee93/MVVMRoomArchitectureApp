package com.mvvmfirstapp.com.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mvvmfirstapp.com.R;
import com.mvvmfirstapp.com.room_database.MartialArt;
import com.mvvmfirstapp.com.vm.MartialArtViewModel;

public class MainActivity extends AppCompatActivity implements ListItemLongClickListner {
    RecyclerView mRecyclerView;
    MartialArtListAdapter mMartialArtListAdapter;
    FloatingActionButton mFloatingActionButton;
    private MartialArtViewModel mMartialArtViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=findViewById(R.id.recyclerview);
        mFloatingActionButton=findViewById(R.id.fab);

        mMartialArtListAdapter=new MartialArtListAdapter(this,new MartialArtListAdapter.MartialArtDiff());

        mRecyclerView.setAdapter(mMartialArtListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mMartialArtViewModel=new ViewModelProvider(this).get(MartialArtViewModel.class);
        mMartialArtViewModel.getAllMartialArts().observe(this,martialArts -> {
            mMartialArtListAdapter.submitList(martialArts);
        });

        mFloatingActionButton.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,NewMartialArtActivity.class);
            mIntentActivityResultLauncher.launch(intent);
        });
    }
    ActivityResultLauncher<Intent> mIntentActivityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result ->
    {
        if (result.getResultCode()== Activity.RESULT_OK){
            Intent data=result.getData();
            String favMartialArts=data.getStringExtra(NewMartialArtActivity.NEW_MARTIAL_ART_KEY);
            String favMartialArts2=data.getStringExtra(NewMartialArtActivity.NEW_NAME_KEY);
            String favMartialArts3=data.getStringExtra(NewMartialArtActivity.NEW_MOBILE_NUMBER_KEY);
            mMartialArtViewModel.insertMartialArts(new MartialArt(favMartialArts,favMartialArts2,favMartialArts3));
        }
    });

    @Override
    public void listItmLongClicked(MartialArt martialArt) {
        AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
        alert.setCancelable(false);
        alert.setTitle("Are You Want To Delete");
        alert.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                mMartialArtViewModel.delteMartialArts(martialArt);

            }
        });
        alert.setNegativeButton("No", (dialogInterface, i) -> {
            dialogInterface.cancel();

        });
        alert.show();
    }
}
