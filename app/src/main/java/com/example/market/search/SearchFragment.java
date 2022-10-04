package com.example.market.search;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.market.R;
import com.example.market.data.Data;
import com.example.market.data.PreferenceManager;
import com.example.market.data.RecommendItemData;
import com.example.market.databinding.FragmentSearchBinding;
import com.google.gson.Gson;

import java.util.ArrayList;


public class SearchFragment extends Fragment implements SearchAdapter.OnClickCategoryListener {
    ArrayList<String> dataTextList = new ArrayList<>();

    String[] trendItem = {};
    ArrayList<RecommendItemData> recommendItemDataList = new ArrayList<>();
    String[] categoryNameList = {};
    Integer[] categoryIconList = {};



    public static SearchFragment getInstance(Bundle bundle) {
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.setArguments(bundle);
        return searchFragment;
    }

    private SearchFragment() {
    }

    private FragmentSearchBinding binding;
    private int position = 0;
    private SearchAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        Bundle bundle = getArguments();
        position = bundle.getInt(Data.SEARCH_POSITION);

        binding.etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String text = binding.etSearch.getText().toString();
                    dataTextList.add(text);

                    Gson gson = new Gson();
                    String jsonPlace = gson.toJson(dataTextList);
                    PreferenceManager.set(getContext(), "key", jsonPlace);

                    adapter.notifyDataSetChanged();
                    Toast.makeText(getContext(), "IME_ACTION_DONE", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        setData();
        adapter = new SearchAdapter(trendItem,recommendItemDataList,categoryNameList,categoryIconList);
        adapter.setOnClickCategoryListener(SearchFragment.this);
        binding.rvSearch.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvSearch.setAdapter(adapter);

        return binding.getRoot();
    }

    public void setData(){
        RecommendItemData recommendItemData1 = new RecommendItemData("Nike","data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHcAAAB3CAMAAAAO5y+4AAAAaVBMVEX///8AAADl5eX29vb5+fm8vLzs7OzKyspOTk7g4ODY2Nj8/PySkpKMjIyenp6bm5saGhrQ0NBcXFx1dXWnp6dtbW07Ozuurq7CwsIyMjJoaGh8fHxTU1MVFRUsLCwjIyNHR0eEhIQNDQ20t47jAAACCElEQVRoge3XyZaDIBAF0C6N4DzHKWpM/v8jWzO0RhHB4KLPqbsN+CJQCD8/CCGEEEIIIYQQQgj9O9phT9Z1zo8GPSZUK1Kbk0trR32mbrvVOeK1sKFQHUryJASPP3sEypPKTId6GUCbb41hC4G6UNuPoRdvL5i+HVGTqeVneLgJlEcAYCrIJIXXPkOvPq9y3mjf0v0yU4/8LnyGgmkIrRUy/MmvitcyqhLeqkiwIKuh9e7VTOjN/MuE8GKJdswfHXZl6lYQX8dQKAPx1ak1Q49MPpQYlxKmOrFpfXmUmnQu9Uz4JFCtU8Wz112ii5VWMCdSrR/e0yO4BvvBXWRC6Et/UtJ3X2O7rU7dbBkKtUDXOWecno2Gdl6HjFA42/Kpk9flvrBmJKwX7Qd44yu3qpk8hP3HSeSZDTMUsnTvt4ROH3NffPj1fuW27MxhExbZ+tmS+VyN69LpVy57cB8q7uFly3LobnlkW7YRrEzoy95pfaG8Z69q5Kt1xt2Raio4/iXbMTOJ8FeOJ5YLvbtqzmBOLZPapfvrZkbifeNC4fFadH6bZNcmvCoQSg1d1RdFSyC1zZXeX564m9LAPOZuurFhiZ9JZS0PSiNXWd0wrJVwvXmD/NKNEdq5hw3wKPoc62vsWwesYBYrr7qsbLPOTFJb0TVY1ImQI5cRQgghhBBCCCGEEELifgEUhRRaGyMaJgAAAABJRU5ErkJggg==","nike_133,000");
        RecommendItemData recommendItemData2 = new RecommendItemData("Adidas","data:image/png;base64,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","adidas_83,000");
        RecommendItemData recommendItemData3 = new RecommendItemData("North Face","data:image/png;base64,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","north face_133,000");
        RecommendItemData recommendItemData4 = new RecommendItemData("Reebok","data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHcAAAA9CAMAAACgJAayAAAAb1BMVEX///8AAAABAQGpqakoKChycnJjY2P7+/vV1dXk5OTs7OzQ0NDLy8ulpaUlJSXn5+f19fWcnJxNTU2wsLA2NjbFxcWVlZV9fX1TU1O+vr4XFxeHh4dtbW24uLhaWlrb29s/Pz8ODg4vLy8eHh5GRkYA5aXiAAADwElEQVRYhe2Y2WKrIBCGXRKJayDue5L6/s94ZgZEm6ZGW3uu8l80IuDHwMwANYy33nrrrd+rD3yp/lVLHvgBf17FoP95G7czR93Fcksf2gTPq85Q9aL3oxzT0uQLW2p5ghb+8yoPqsKtXPN2iKKoMmEANb3irhQV2FkWuORCnaf7umnp8zn33Pfuem5BDwH0teArp2E0HwCsHgsZcfsj/Emk1XFEFY03ceFj1/Xci3zKobNrlIpjIZdfdUlIbk7FVjUnVa7mQnNnM1egifgF81oUV7IXrbsVRWdpe8Xlji04jc/K4gKGNBDXximzVrvXxAVUZ2TKmg5Hzk05/pRmYvQrQcZdYESeMttH7tW5YFAsuuYDl9lxHGOvHnkdvG3JXBw/+AmL0NzJn6F4ZBW9k0trc1NFRb0WS37lyYUqIHUAvdF+ksLXPDIpYTNuAlx+o5mFQcFDqLkf9g+4HdgG/mv1hhu3ONln+BoYBZOB0YHcE/yW5N0AHww1MyUuSNanBfykG7hMCOEg+Uwfr7IQJDJuDABuBJUCqsqFID92yRFyj5U39DLlV7gC3Xqu9Csbl4cMnuLXnQrozzqzxTC/ia6ydRzhiqzkdmOo40Kh84oZ1+ivc65SQlmaFxqruRB3h5XcNI5L+XRXQe+VNimkFOjHsuAbXkhP8WnsGtSXwQkxmDi4AO5nQRy3K7mT7uuTza76WO8Uu6ps22+217eei537YO3+i80D0VxvVvURHb4oyr3lvp57KmORNwXE8z1vN2DVUNOsq8xnyp7keub1qV0DTHc55OXyCJfgfZurNGSNwmQ/j8lzYNfO9WGEjr3Vzq/iaT08ohPKFb04JjOYHJR5qIPVm98reWl+n6FNdYqqP40Hn6P6tBtUybWdCQO/AgCuMx/Lrf7mWPtb8TSPRjQsM+bxNMEirWm6t6VzMb+u9Fp2mPtpv4rCHzvvC/lH8177ZJJE0+6bwx7lHZs/ml+D28pxo5yuYixoFLlafYDaLum3o8sOMjQ5HTix/EfGejlZprAdRC4Pc4oWt55uJnuLZfOwdcCRWIirm2R4v2WlPNxsvHO+VlnNqHSOKiPlUmZB5x6XnCzZdafmjTZW7QeeoxPHMKZg1uJKOxvv9wvqo5mxEabk9Kaxx3nL03HHyW7nqddBR8om6x8hXNzN29q7waLsORYO8AxPw99hUeBjO0z2Jyzd9JwJmz/vA7f/7JfY9tMJQ2FHDd9249lQ/gbLm6NWQ/9dSZ3pxdJssjbbz7O3qf/LDfGtt95663/qHx4rMY71y/x4AAAAAElFTkSuQmCC","reebok_133,000");
        RecommendItemData recommendItemData5 = new RecommendItemData("Jordan","https://i.pinimg.com/550x/a2/bc/bb/a2bcbb216b790eb34844962944a3a16e.jpg","jordan_200,000");

        recommendItemDataList.add(recommendItemData1);
        recommendItemDataList.add(recommendItemData2);
        recommendItemDataList.add(recommendItemData3);
        recommendItemDataList.add(recommendItemData4);
        recommendItemDataList.add(recommendItemData5);

        trendItem = new String[]{"나이키", "아디다스", "베이프", "슈프림", "바시티", "스투시", "오프화이트", "유니온", "조던", "노스페이스"};

        categoryNameList = new String[]{"스니커즈", "시계", "스타굿즈", "자전거", "오토바이/스쿠터", "피규어/인형", "닌텐도/NDS/Will", "헬스/요가/필라테스", "축구", "전동킥보드/전동휠", "캠핑", "카메라/DSLR"};
        categoryIconList = new Integer[]{R.drawable.ic_sneakers_24, R.drawable.ic_hand_watch_24, R.drawable.ic_star_24, R.drawable.ic_bike_24,
                R.drawable.ic_motor_24, R.drawable.ic_doll_24, R.drawable.ic_nds_will_24, R.drawable.ic_fitness_24,
                R.drawable.ic_soccer_24, R.drawable.ic_kickboard_24, R.drawable.ic_camping_24, R.drawable.ic_camera_24};
    }

    @Override
    public void onCategory(String[] tabName, Integer[] tabIcons, int position) {
        Toast.makeText(getContext(), tabName[position] + "을 터치하셨습니다", Toast.LENGTH_SHORT).show();
    }
}
