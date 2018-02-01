package com.oleeja.soccerinfo.presentation.common;

import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.oleeja.soccerinfo.R;

public class BaseFragment extends Fragment {

    private AlertDialog mUploadingDialog;

    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    public void showUploading() {
        if (mUploadingDialog == null) {
            mUploadingDialog = new AlertDialog.Builder(getContext())
                    .setView(R.layout.view_loading_dialog)
                    .show();
            mUploadingDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            mUploadingDialog.setCancelable(false);
        } else {
            mUploadingDialog.show();
        }
    }

    public void hideUploading() {
        if (mUploadingDialog != null) {
            mUploadingDialog.dismiss();
        }
    }
}
