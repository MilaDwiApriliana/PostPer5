package com.mila141.posttestpemrogrammobile5

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.mila141.posttestpemrogrammobile5.databinding.DialogAddPostBinding
import com.mila141.posttestpemrogrammobile5.model.Post

class AddPostDialog(private val onPostAdded: (Post) -> Unit) : DialogFragment() {

    private var selectedImageUri: Uri? = null
    private lateinit var binding: DialogAddPostBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        binding = DialogAddPostBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)

        // Pilih gambar dari galeri
        binding.previewImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 100)
        }

        // Tombol Simpan
        binding.btnSave.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val caption = binding.etCaption.text.toString()

            if (username.isNotEmpty() && caption.isNotEmpty()) {
                val newPost = Post(username, caption, imageUri = selectedImageUri)
                onPostAdded(newPost)
                dismiss()
            } else {
                binding.etCaption.error = "Isi semua kolom!"
            }
        }

        return dialog
    }

    // Hasil pilih gambar
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            selectedImageUri = data?.data
            binding.previewImage.setImageURI(selectedImageUri)
        }
    }
}
