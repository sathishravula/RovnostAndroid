package com.ehc.rovnostandroid.ui;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.ehc.rovnostandroid.R;
import com.gc.materialdesign.views.ButtonRectangle;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import de.hdodenhof.circleimageview.CircleImageView;


public class MyProfile extends BaseActivity implements AdapterView.OnItemClickListener, View.OnClickListener {


    private static final int REQUEST_CAMERA = 101;
    private static final int SELECT_FILE = 102;
    private String[] bloodGroups;
    private String[] maritalStatus;
    private String[] feets;
    private String[] inches;
    private ButtonRectangle changePassword;
    private ButtonRectangle profile;
    private CircleImageView camera;
    private CircleImageView profileImage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle("My Profile");
        changePassword = (ButtonRectangle) findViewById(R.id.pwd);
        profile = (ButtonRectangle) findViewById(R.id.profile);
        camera = (CircleImageView) findViewById(R.id.camera);
        profileImage = (CircleImageView) findViewById(R.id.profile_image);
        changePassword.setOnClickListener(this);
        camera.setOnClickListener(this);
        profile.setOnClickListener(this);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            setActionBarIcon(R.drawable.ic_navigate_before_white_36dp);
        }
        bloodGroups = getResources().getStringArray(R.array.blood_groups);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.simple_dropdown_item_1line, bloodGroups);
        BetterSpinner textView = (BetterSpinner)
                findViewById(R.id.bg_spinner);
        textView.setAdapter(adapter);
        textView.setOnItemClickListener(this);
//        textView.set
//        textView.setSelection(2);
        maritalStatus = getResources().getStringArray(R.array.marital_status);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.simple_dropdown_item_1line, maritalStatus);
        textView = (BetterSpinner)
                findViewById(R.id.marital_spinner);
        textView.setAdapter(adapter1);
        textView.setOnItemClickListener(this);
        feets = getResources().getStringArray(R.array.feets);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                R.layout.simple_dropdown_item_1line, feets);
        textView = (BetterSpinner)
                findViewById(R.id.feets_spinner);
        textView.setAdapter(adapter2);
        textView.setOnItemClickListener(this);
        inches = getResources().getStringArray(R.array.inches);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                R.layout.simple_dropdown_item_1line, inches);
        textView = (BetterSpinner)
                findViewById(R.id.inch_spinner);
        textView.setAdapter(adapter3);
        textView.setOnItemClickListener(this);


    }


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_my_profile;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, parent.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pwd:
                Intent intent = new Intent(this, ChangePassword.class);
                startActivity(intent);
                break;
            case R.id.profile:
                Toast.makeText(this, "profile saved sucessfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.camera:
                new MaterialDialog.Builder(this)
                        .title(R.string.choose_image)
                        .items(R.array.folders)
                        .backgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {

                                if (text.equals("Camera")) {
                                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                    startActivityForResult(intent, REQUEST_CAMERA);
                                } else if (text.equals("Gallery")) {
                                    Intent intent = new Intent(
                                            Intent.ACTION_PICK,
                                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                    intent.setType("image/*");
                                    startActivityForResult(
                                            Intent.createChooser(intent, "Select File"),
                                            SELECT_FILE);
                                }
                            }
                        })
                        .show();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {
                Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                profileImage.setImageBitmap(thumbnail);
            } else if (requestCode == SELECT_FILE) {
                Uri selectedImageUri = data.getData();
                String[] projection = {MediaStore.MediaColumns.DATA};
                CursorLoader cursorLoader = new CursorLoader(this, selectedImageUri, projection, null, null,
                        null);
                Cursor cursor = cursorLoader.loadInBackground();
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
                cursor.moveToFirst();
                String selectedImagePath = cursor.getString(column_index);
                Bitmap bm;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(selectedImagePath, options);
                final int REQUIRED_SIZE = 200;
                int scale = 1;
                while (options.outWidth / scale / 2 >= REQUIRED_SIZE
                        && options.outHeight / scale / 2 >= REQUIRED_SIZE)
                    scale *= 2;
                options.inSampleSize = scale;
                options.inJustDecodeBounds = false;
                bm = BitmapFactory.decodeFile(selectedImagePath, options);
                profileImage.setImageBitmap(bm);
            }
        }
    }
}
