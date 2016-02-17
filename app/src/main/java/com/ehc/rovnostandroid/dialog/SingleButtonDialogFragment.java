package com.ehc.rovnostandroid.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

@SuppressLint("ValidFragment")
public class SingleButtonDialogFragment extends DialogFragment {

  protected int positiveButtonTitle;
  protected String message;
  protected String title;
  protected boolean isCancelable;
  protected IDialogClickListener dialogListener;

  public SingleButtonDialogFragment(int positiveButtonTitle,
                                    String message, String title, boolean isCancelable) {
    this.positiveButtonTitle = positiveButtonTitle;
    this.message = message;
    this.title = title;
    this.isCancelable = isCancelable;
  }

  public SingleButtonDialogFragment() {

  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }

  public void setDialogListener(IDialogClickListener dialogListener) {
    this.dialogListener = dialogListener;
  }

  public IDialogClickListener getDialogListener() {
    return dialogListener;
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
        .setTitle(title)
        .setCancelable(isCancelable)
        .setMessage(message)
        .setPositiveButton(positiveButtonTitle,
            new DialogInterface.OnClickListener() {

              @Override
              public void onClick(DialogInterface dialog,
                                  int which) {
                if (dialogListener != null) {
                  dialogListener.onPositiveButtonClick(dialog, which);
                }
              }
            });

    return builder.create();
  }

  @Override
  public void onDestroyView() {
    if (getDialog() != null && getRetainInstance())
      getDialog().setDismissMessage(null);
    super.onDestroyView();
  }
}