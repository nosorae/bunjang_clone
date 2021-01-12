package com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentBungaeTalkBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewItem


class BungaeTalkFragment :
    BaseFragment<FragmentBungaeTalkBinding>(FragmentBungaeTalkBinding::bind, R.layout.fragment_bungae_talk) {


    private var recyclerItemList = ArrayList<BungaeTalkRecyclerViewItem>()
    private lateinit var recyclerAdapter : BungaeTalkRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            recyclerItemList.add(BungaeTalkRecyclerViewItem(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTu7kRo2InSmL_gTYmcFbD4HuOjJYxtsxfacA&usqp=CAU",
                "쿨거만합니다",
                "찜하셔서 연락드렸어요, 네고 가능합니다",
                "오전 9:32",
                1
            ))
        recyclerItemList.add(BungaeTalkRecyclerViewItem(
            "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/be0ca190-877a-4188-9e92-6884dc341046/dcb8hr0-e44cd344-64ed-45ea-8b80-1a4a13bd7133.jpg/v1/fill/w_280,h_350,q_70,strp/hello__by_katiecat83_dcb8hr0-350t.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3siaGVpZ2h0IjoiPD0xMjgwIiwicGF0aCI6IlwvZlwvYmUwY2ExOTAtODc3YS00MTg4LTllOTItNjg4NGRjMzQxMDQ2XC9kY2I4aHIwLWU0NGNkMzQ0LTY0ZWQtNDVlYS04YjgwLTFhNGExM2JkNzEzMy5qcGciLCJ3aWR0aCI6Ijw9MTAyNCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.iq7keUwQKWfvKS5R4eZxn2JGDRM4-bDsPrRomI_X9yI",
            "나미야",
            "찜하셨더라구요",
            "오후 3:30",
            2
        ))
        recyclerItemList.add(BungaeTalkRecyclerViewItem(
            "https://t1.daumcdn.net/cfile/tistory/994BEF355CD0313D05?download",
            "잡화점",
            "상태 좋아요",
            "오후 7:22",
            0
        ))


        recyclerAdapter = BungaeTalkRecyclerViewAdapter(context, recyclerItemList)
        binding.bungaeTalkRecyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(context)
        }

    }
}