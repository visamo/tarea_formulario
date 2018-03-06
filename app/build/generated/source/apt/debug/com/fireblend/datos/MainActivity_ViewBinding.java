// Generated code from Butter Knife. Do not modify!
package com.fireblend.datos;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131165219;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.nombre = Utils.findRequiredViewAsType(source, R.id.nombre, "field 'nombre'", EditText.class);
    target.correo = Utils.findRequiredViewAsType(source, R.id.correo, "field 'correo'", EditText.class);
    target.edad = Utils.findRequiredViewAsType(source, R.id.edad, "field 'edad'", SeekBar.class);
    target.textoEdad = Utils.findRequiredViewAsType(source, R.id.textoEdad, "field 'textoEdad'", TextView.class);
    view = Utils.findRequiredView(source, R.id.botonMostrar, "method 'mostrar'");
    view2131165219 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.mostrar();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.nombre = null;
    target.correo = null;
    target.edad = null;
    target.textoEdad = null;

    view2131165219.setOnClickListener(null);
    view2131165219 = null;
  }
}
