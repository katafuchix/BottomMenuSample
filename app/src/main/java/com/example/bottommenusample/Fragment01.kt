package com.example.bottommenusample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.fragment01.view.*
import kotlinx.android.synthetic.main.fragment_bottom_sheet.view.*

class Fragment01 : Fragment() {

    // ビュー生成
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // この中で初期化処理を行うイメージ

        // xmlから実態を生成
        val fragment01 = inflater.inflate(
            R.layout.fragment01,
            container, false
        )

        // ボタン処理 BottomSheetDialogFragmentで表示
        fragment01.button_01.setOnClickListener {
            showBottomSheetDialogFragment()
        }

        //  ボタン処理 BottomSheetDialogで表示
        fragment01.pop_01.setOnClickListener {
            showBottomSheetDialog()
        }

        // 最後に生成したビューを返す
        return fragment01
    }

    private fun showBottomSheetDialogFragment() {
        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(fragmentManager, bottomSheetFragment.tag)
    }


    private fun showBottomSheetDialog() {
        val view = layoutInflater.inflate(R.layout.fragment_bottom_sheet, null)
        val dialog = BottomSheetDialog(this.context!!)
        dialog.setContentView(view)
        view.textViewFacebook.setOnClickListener {
            Toast.makeText(this.context!!, "Facebook", Toast.LENGTH_SHORT).show()
        }
        view.textViewTwitter.setOnClickListener {
            Toast.makeText(this.context!!, "Twitter", Toast.LENGTH_SHORT).show()
        }
        view.textViewInstagram.setOnClickListener {
            Toast.makeText(this.context!!, "Instagram", Toast.LENGTH_SHORT).show()
        }
        view.textViewLinkedin.setOnClickListener {
            Toast.makeText(this.context!!, "Linkedin", Toast.LENGTH_SHORT).show()
        }
        dialog.show()
    }

    // インスタンス生成
    // 他クラスから利用する場合にこのメソッドを呼ぶ
    companion object {
        fun newInstance(): Fragment01 {
            // Fragemnt01 インスタンス生成
            val fragment01 = Fragment01()

            return fragment01
        }
    }
}