package de.codecamp.mre.summernote.components;


import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.BlurNotifier;
import com.vaadin.flow.component.FocusNotifier;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.data.value.HasValueChangeMode;
import com.vaadin.flow.data.value.ValueChangeMode;


@Tag("html-area")
@NpmPackage(value = "jquery", version = "3.6.0")
@NpmPackage(value = "@types/jquery", version = "3.5.16")
@NpmPackage(value = "summernote", version = "0.8.20")
@JsModule("./components/html-area.ts")
public class HtmlArea
  extends
    AbstractSinglePropertyField<HtmlArea, String>
  implements
    HasStyle,
    HasValueChangeMode,
    FocusNotifier<HtmlArea>,
    BlurNotifier<HtmlArea>
{

  private int valueChangeTimeout = DEFAULT_CHANGE_TIMEOUT;

  private ValueChangeMode valueChangeMode;


  public HtmlArea()
  {
    super("value", "", true);

    setValueChangeMode(ValueChangeMode.ON_BLUR);
  }


  @Override
  public ValueChangeMode getValueChangeMode()
  {
    return valueChangeMode;
  }

  @Override
  public void setValueChangeMode(ValueChangeMode valueChangeMode)
  {
    this.valueChangeMode = valueChangeMode;
    setSynchronizedEvent(ValueChangeMode.eventForMode(valueChangeMode, "value-changed"));
    applyChangeTimeout();
  }

  @Override
  public void setValueChangeTimeout(int valueChangeTimeout)
  {
    this.valueChangeTimeout = valueChangeTimeout;
    applyChangeTimeout();
  }

  @Override
  public int getValueChangeTimeout()
  {
    return valueChangeTimeout;
  }

  private void applyChangeTimeout()
  {
    ValueChangeMode.applyChangeTimeout(valueChangeMode, valueChangeTimeout,
        getSynchronizationRegistration());
  }

}
