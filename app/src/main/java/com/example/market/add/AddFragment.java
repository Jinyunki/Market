package com.example.market.add;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market.data.Data;
import com.example.market.data.DataProduct;
import com.example.market.databinding.FragmentAddBinding;
import com.example.market.databinding.ListitemCaptureBinding;
import com.example.market.room.Product;
import com.example.market.room.ProductDAO;
import com.example.market.room.ProductDB;

import java.io.InputStream;
import java.util.ArrayList;

public class AddFragment extends Fragment {

    ProductDAO productDAO;
    int productId = -1;

    public static AddFragment getInstance(Bundle bundle) {
        AddFragment addFragment = new AddFragment();
        addFragment.setArguments(bundle);
        return addFragment;
    }

    private AddFragment() {
    }

    private FragmentAddBinding binding;
    private int position = 0;

    CaptureAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(inflater, container, false);
        Bundle bundle = getArguments();
        position = bundle.getInt(Data.ADD_POSITION);

        binding.tvLocation.setText("서울시 관악구");

        adapter = new CaptureAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        binding.rvCapture.setLayoutManager(linearLayoutManager);
        binding.rvCapture.setAdapter(adapter);

        onCameraBind();
        checkSelfPermission();
        setData();
        return binding.getRoot();
    }


    public void setData() {

        binding.btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productName = binding.etProductName.getText().toString();
                String productCategory = binding.etCategory.getText().toString();
                String tag = binding.etTag.getText().toString();
                String productDescription = binding.etDescription.getText().toString();
                String price = binding.etPrice.getText().toString();
                int priceValue = Integer.parseInt(price);

                if (productName.isEmpty() || productDescription.isEmpty()) {
                    Toast.makeText(getContext(), "제목과,내용을 입력해 주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (productId >= 0) {
                    Product product = new Product(productId, productName, productCategory, tag, priceValue, productDescription);

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            getProductDAO().updateDiary(product);
                        }
                    }).start();
                } else {
                    Product product = new Product(productName, productCategory, tag, priceValue, productDescription);

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            getProductDAO().insertAll(product);
                            System.out.println("productName : " + productName + ", productCategory : " + productCategory + ", tag : " + tag +
                                    ", priceValue : " + priceValue + ", productDescription : " + productDescription);
                            editTextClear();
                        }
                    }).start();
                }
            }

        });

    }


    private ProductDAO getProductDAO() {
        if (productDAO == null) {
            productDAO = ProductDB.getInstance(getContext()).productDAO();
        }
        return productDAO;
    }

    private void editTextClear() {
        binding.etProductName.setText(null);
        binding.etCategory.setText(null);
        binding.etTag.setText(null);
        binding.etDescription.setText(null);
        binding.etPrice.setText(null);
    }

    public void onCameraBind() {
        binding.ivCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 101);
            }
        });
    }

    //권한에 대한 응답이 있을때 작동하는 함수
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //권한을 허용 했을 경우
        if (requestCode == 1) {
            int length = permissions.length;
            for (int i = 0; i < length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    // 동의
                    Log.d("MainActivity", "권한 허용 : " + permissions[i]);
                }
            }
        }

    }

    public void checkSelfPermission() {

        String temp = "";

        //파일 읽기 권한 확인
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            temp += Manifest.permission.READ_EXTERNAL_STORAGE + " ";
        }

        //파일 쓰기 권한 확인
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            temp += Manifest.permission.WRITE_EXTERNAL_STORAGE + " ";
        }


        if (TextUtils.isEmpty(temp) == false) {
            // 권한 요청
            ActivityCompat.requestPermissions(getActivity(), temp.trim().split(" "), 1);
        } else {
            // 모두 허용 상태
            Toast.makeText(getActivity(), "권한을 모두 허용", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 101 && resultCode == RESULT_OK) {
            try {
                InputStream is = getActivity().getContentResolver().openInputStream(data.getData());
                Bitmap bm = BitmapFactory.decodeStream(is);
                is.close();
                ListitemCaptureBinding captureBinding = null;
                captureBinding.ivCapture.setImageBitmap(bm);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (requestCode == 101 && resultCode == RESULT_CANCELED) {
            Toast.makeText(getActivity(), "취소", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ProductDB.destroyInstance();
    }
}


