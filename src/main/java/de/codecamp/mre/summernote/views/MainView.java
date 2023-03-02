package de.codecamp.mre.summernote.views;


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import de.codecamp.mre.summernote.components.HtmlArea;


@Route("")
public class MainView
  extends
    Composite<VerticalLayout>
{

  @Override
  protected VerticalLayout initContent()
  {
    VerticalLayout content = super.initContent();

    content.add(new Button("Test"));


    HtmlArea htmlArea = new HtmlArea();
    content.add(htmlArea);

    htmlArea.setValue("Initial value");

    htmlArea.addValueChangeListener(event ->
    {
      System.out.println("New Value: " + event.getValue());
    });


    content.add(new Button("Test"));

    return content;
  }

}
