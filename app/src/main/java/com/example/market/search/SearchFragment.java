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
import com.example.market.data.CategoryData;
import com.example.market.data.Data;
import com.example.market.data.PreferenceManager;
import com.example.market.data.RecommendItemData;
import com.example.market.databinding.FragmentSearchBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment implements SearchAdapter.OnClickCategoryListener {
    ArrayList<String> dataTextList = new ArrayList<>();

    String[] trendItem = {"나이키", "아디다스", "베이프", "슈프림", "바시티", "스투시", "오프화이트", "유니온", "조던", "노스페이스"};
    ArrayList<RecommendItemData> recommendItemDataList = new ArrayList<>();
    ArrayList<CategoryData> categoryDataList = new ArrayList<>();


    String[] categoryNameList = {"스니커즈","시계","스타굿즈","자전거","오토바이/스쿠터","피규어/인형","닌텐도/NDS/Will","헬스/요가/필라테스","축구","전동킥보드/전동휠","캠핑","카메라/DSLR"};
    Integer[] categoryIconList = {R.drawable.ic_sneakers_24,R.drawable.ic_hand_watch_24,R.drawable.ic_star_24,R.drawable.ic_bike_24,
            R.drawable.ic_motor_24,R.drawable.ic_doll_24,R.drawable.ic_nds_will_24,R.drawable.ic_fitness_24,
            R.drawable.ic_soccer_24,R.drawable.ic_kickboard_24,R.drawable.ic_camping_24,R.drawable.ic_camera_24};



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

        adapter = new SearchAdapter(trendItem,recommendItemDataList,categoryNameList,categoryIconList);
        adapter.setOnClickCategoryListener(SearchFragment.this);
        binding.rvSearch.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvSearch.setAdapter(adapter);
        setData();

        return binding.getRoot();
    }

    public void setData(){
        RecommendItemData recommendItemData1 = new RecommendItemData("Nike1","https://media.bunjang.co.kr/product/200270119_1_1664089027_w292.jpg","nike_133,000");
        RecommendItemData recommendItemData2 = new RecommendItemData("Nike2","https://media.bunjang.co.kr/product/200270119_1_1664089027_w292.jpg","nike_133,000");
        RecommendItemData recommendItemData3 = new RecommendItemData("Nike3","https://media.bunjang.co.kr/product/200270119_1_1664089027_w292.jpg","nike_133,000");
        RecommendItemData recommendItemData4 = new RecommendItemData("Nike4","https://media.bunjang.co.kr/product/200270119_1_1664089027_w292.jpg","nike_133,000");
        RecommendItemData recommendItemData5 = new RecommendItemData("Nike5","https://media.bunjang.co.kr/product/200270119_1_1664089027_w292.jpg","nike_133,000");

        recommendItemDataList.add(recommendItemData1);
        recommendItemDataList.add(recommendItemData2);
        recommendItemDataList.add(recommendItemData3);
        recommendItemDataList.add(recommendItemData4);
        recommendItemDataList.add(recommendItemData5);

    }

    @Override
    public void onCategory(String[] tabName, Integer[] tabIcons, int position) {
        Toast.makeText(getContext(), tabName[position] + "을 터치하셨습니다", Toast.LENGTH_SHORT).show();
    }
}
