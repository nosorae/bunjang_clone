package com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityOneCategoryBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.model.OneCategoryResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.model.OneCategoryResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.one_category_recycler.OneCategoryRecyclerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.one_category_recycler.OneCategoryRecyclerItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.one_item_recylcer.OneItemRecyclerAdapter

class OneCategoryActivity :
        BaseActivity<ActivityOneCategoryBinding>(ActivityOneCategoryBinding::inflate),
        OneCategoryActivityView {

    private var recyclerCategoryList = ArrayList<OneCategoryRecyclerItem>()
    private lateinit var recyclerCategoryAdapter : OneCategoryRecyclerAdapter

    private var recyclerItemList = ArrayList<OneCategoryResult>()
    private lateinit var recyclerItemAdapter : OneItemRecyclerAdapter
    //1: 여성의류, 2: 남성의류, 3: 패션잡화, 4: 뷰티/미용, 5: 유아동/출산, 6: 스포츠/레저
    val categoryArray = ArrayList<ArrayList<OneCategoryRecyclerItem>>()
    val category1 = ArrayList<OneCategoryRecyclerItem>()
    val category2 = ArrayList<OneCategoryRecyclerItem>()
    val category3 = ArrayList<OneCategoryRecyclerItem>()
    val category4 = ArrayList<OneCategoryRecyclerItem>()
    val category5 = ArrayList<OneCategoryRecyclerItem>()
    val category6 = ArrayList<OneCategoryRecyclerItem>()

    var categoryNum = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.oneCategoryButtonBack.setOnClickListener {
            finish()
        }

        categoryNum = intent.getIntExtra("categoryNum", 1)

        when(categoryNum){
            1 -> binding.oneCategoryTitle.text = "여성의류"
            2 -> binding.oneCategoryTitle.text = "남성의류"
            3 -> binding.oneCategoryTitle.text = "패션잡화"
            4 -> binding.oneCategoryTitle.text = "뷰티/미용"
            5 -> binding.oneCategoryTitle.text = "유아동/출산"
            else -> binding.oneCategoryTitle.text = "스포츠/레저"
        }
        OneCategoryService(this).tryGetUsers(categoryNum)

        category1.add(OneCategoryRecyclerItem("전체보기", "2,133,321"))
        category1.add(OneCategoryRecyclerItem("원피스", "395,187"))
        category1.add(OneCategoryRecyclerItem("야상/점퍼/패딩", "171,048"))
        category1.add(OneCategoryRecyclerItem("스커트/치마", "169,454"))
        category1.add(OneCategoryRecyclerItem("자켓", "168,472"))
        category1.add(OneCategoryRecyclerItem("니트/스웨터", "162,517"))
        category1.add(OneCategoryRecyclerItem("코트", "145,842"))
        category1.add(OneCategoryRecyclerItem("블라우스", "144,924"))
        category1.add(OneCategoryRecyclerItem("반팔 티셔츠", "111,900"))
        category1.add(OneCategoryRecyclerItem("맨투맨/후드티", "108,924"))
        category1.add(OneCategoryRecyclerItem("가디건", "91,576"))
        category1.add(OneCategoryRecyclerItem("청바지/스키니(긴)", "75,074"))
        category1.add(OneCategoryRecyclerItem("면/캐주얼 바지(긴)", "69,119"))
        category1.add(OneCategoryRecyclerItem("셔츠/남방", "58,583"))
        category1.add(OneCategoryRecyclerItem("트레이닝", "54,103"))
        category1.add(OneCategoryRecyclerItem("긴팔 티셔츠", "52,035"))
        category1.add(OneCategoryRecyclerItem("조끼/베스트", "36,008"))
        category1.add(OneCategoryRecyclerItem("반바지/핫팬츠", "35,337"))
        category1.add(OneCategoryRecyclerItem("테마/이벤트 의류", "25,901"))
        category1.add(OneCategoryRecyclerItem("언더웨어/속옷", "23,231"))
        category1.add(OneCategoryRecyclerItem("레깅스", "11,065"))
        category1.add(OneCategoryRecyclerItem("비즈니스 정장", "8,729"))
        category1.add(OneCategoryRecyclerItem("빅사이즈", "6,268"))

        category2.add(OneCategoryRecyclerItem("전체 보기","1,302,558"))
        category2.add(OneCategoryRecyclerItem("점퍼/야상/패딩","240,672"))
        category2.add(OneCategoryRecyclerItem("맨투맨/후드티","208,123"))
        category2.add(OneCategoryRecyclerItem("반팔 티셔츠","152,610"))
        category2.add(OneCategoryRecyclerItem("자켓","114,056"))
        category2.add(OneCategoryRecyclerItem("셔츠/남방","97,336"))
        category2.add(OneCategoryRecyclerItem("트레이닝","91,692"))
        category2.add(OneCategoryRecyclerItem("니트/스웨터","76,721"))
        category2.add(OneCategoryRecyclerItem("청바지(긴)","62,928"))
        category2.add(OneCategoryRecyclerItem("면/캐주얼 바지(긴)","56,025"))
        category2.add(OneCategoryRecyclerItem("코트","41,483"))
        category2.add(OneCategoryRecyclerItem("긴팔 티셔츠","35,540"))
        category2.add(OneCategoryRecyclerItem("반바지/7~9부","23,966"))
        category2.add(OneCategoryRecyclerItem("가디건","20,907"))
        category2.add(OneCategoryRecyclerItem("조끼/베스트","18,803"))
        category2.add(OneCategoryRecyclerItem("비즈니스 정장","10,302"))
        category2.add(OneCategoryRecyclerItem("언더웨어/속옷","4,245"))
        category2.add(OneCategoryRecyclerItem("테마/이벤트 의류","3,084"))
        category2.add(OneCategoryRecyclerItem("빅사이즈","2,744"))

        category3.add(OneCategoryRecyclerItem("전체보기", "1,929,225"))
        category3.add(OneCategoryRecyclerItem("여성가방", "469,835"))
        category3.add(OneCategoryRecyclerItem("운동화/캐주얼화", "323,303"))
        category3.add(OneCategoryRecyclerItem("주얼리/액세서리", "261,855"))
        category3.add(OneCategoryRecyclerItem("여성화", "195,588"))
        category3.add(OneCategoryRecyclerItem("지갑", "148,371"))
        category3.add(OneCategoryRecyclerItem("시계", "100,911"))
        category3.add(OneCategoryRecyclerItem("벨트/장갑/스타킹/기타", "99,822"))
        category3.add(OneCategoryRecyclerItem("남성가방", "90,276"))
        category3.add(OneCategoryRecyclerItem("모자", "86,212"))
        category3.add(OneCategoryRecyclerItem("남성화", "73,023"))
        category3.add(OneCategoryRecyclerItem("안경/선글라스", "42,052"))
        category3.add(OneCategoryRecyclerItem("여행용가방/소풍", "16,217"))

        category4.add(OneCategoryRecyclerItem("전체보기","299,602"))
        category4.add(OneCategoryRecyclerItem("색조메이크업","76,042"))
        category4.add(OneCategoryRecyclerItem("스킨케어","61,079"))
        category4.add(OneCategoryRecyclerItem("향수/아로마","33,205"))
        category4.add(OneCategoryRecyclerItem("이미용품/미용기기","32,578"))
        category4.add(OneCategoryRecyclerItem("헤어/바디","29,048"))
        category4.add(OneCategoryRecyclerItem("베이스메이크업","28,417"))
        category4.add(OneCategoryRecyclerItem("네일아트/케어","22,371"))
        category4.add(OneCategoryRecyclerItem("다이어트/이색 뷰티","8,277"))
        category4.add(OneCategoryRecyclerItem("썬케어","4,445"))
        category4.add(OneCategoryRecyclerItem("남성 화장품","1,832"))

        category5.add(OneCategoryRecyclerItem("전체보기","294,006"))
        category5.add(OneCategoryRecyclerItem("여아의류(3-6세)","54,996"))
        category5.add(OneCategoryRecyclerItem("유아동신발/잡화","44,937"))
        category5.add(OneCategoryRecyclerItem("교육/완구/인형","35,188"))
        category5.add(OneCategoryRecyclerItem("남아의류(3-6세)","36,734"))
        category5.add(OneCategoryRecyclerItem("유아동용품","32,717"))
        category5.add(OneCategoryRecyclerItem("베이비의류(0-2세)","31,071"))
        category5.add(OneCategoryRecyclerItem("여주니어의류(7세~)","22,588"))
        category5.add(OneCategoryRecyclerItem("남주니어의류(7세~)","21,010"))
        category5.add(OneCategoryRecyclerItem("기저귀/수유/이유식","5,482"))
        category5.add(OneCategoryRecyclerItem("출산/임부용품","5,343"))

        category6.add(OneCategoryRecyclerItem("전체보기","327,977"))
        category6.add(OneCategoryRecyclerItem("헬스/요가/골프","131,884"))
        category6.add(OneCategoryRecyclerItem("축구/야구/농구","57,833"))
        category6.add(OneCategoryRecyclerItem("자전거/MTB","30,890"))
        category6.add(OneCategoryRecyclerItem("등산","24,834"))
        category6.add(OneCategoryRecyclerItem("낚시/캠핑 용품","24,413"))
        category6.add(OneCategoryRecyclerItem("수영","20,550"))
        category6.add(OneCategoryRecyclerItem("기타구기 스포츠","20,104"))
        category6.add(OneCategoryRecyclerItem("스키/스노우보드","7,901"))
        category6.add(OneCategoryRecyclerItem("전동킥보드/전동휠","4,499"))
        category6.add(OneCategoryRecyclerItem("인라인/스케이트보드","3,041"))

        categoryArray.add(category1)
        categoryArray.add(category2)
        categoryArray.add(category3)
        categoryArray.add(category4)
        categoryArray.add(category5)
        categoryArray.add(category6)







        if(categoryNum > 0) {
            for(i in 0..7) {
                recyclerCategoryList.add(categoryArray[categoryNum-1][i])
            }
        }

        recyclerCategoryAdapter = OneCategoryRecyclerAdapter(this, recyclerCategoryList)
        binding.oneCategoryCategoryRecycler.apply {
            adapter = recyclerCategoryAdapter
            layoutManager = GridLayoutManager(context, 2)
        }

        binding.oneCategoryOpenButton.setOnClickListener {
            if(categoryNum > 0){
                if(recyclerCategoryList.size == 8) {
                    recyclerCategoryList = categoryArray[categoryNum-1]
                    recyclerCategoryAdapter = OneCategoryRecyclerAdapter(this, recyclerCategoryList)
                    binding.oneCategoryCategoryRecycler.apply {
                        adapter = recyclerCategoryAdapter
                        layoutManager = GridLayoutManager(context, 2)
                    }
                    binding.oneCategoryCategoryOpenText.text = "접어보기"
                    binding.oneCategoryCategoryOpenImage.setImageResource(R.drawable.global_fold)
                } else {
                    recyclerCategoryList = ArrayList<OneCategoryRecyclerItem>()
                    for(i in 0..7) {
                        recyclerCategoryList.add(categoryArray[categoryNum-1][i])
                    }
                    recyclerCategoryAdapter = OneCategoryRecyclerAdapter(this, recyclerCategoryList)
                    binding.oneCategoryCategoryRecycler.apply {
                        adapter = recyclerCategoryAdapter
                        layoutManager = GridLayoutManager(context, 2)
                    }
                    binding.oneCategoryCategoryOpenText.text = "펼쳐보기"
                    binding.oneCategoryCategoryOpenImage.setImageResource(R.drawable.global_open)
                }


            }

        }












    }

    override fun onGetItemSuccess(response: OneCategoryResponse) {

        recyclerItemList = response.result as ArrayList<OneCategoryResult>
        recyclerItemAdapter = OneItemRecyclerAdapter(this, recyclerItemList)
        binding.oneCategoryItemRecycler.apply {
            adapter = recyclerItemAdapter
            layoutManager = GridLayoutManager(context, 3)
        }
    }

    override fun onGetItemFailure(message: String) {
        TODO("Not yet implemented")
    }
}