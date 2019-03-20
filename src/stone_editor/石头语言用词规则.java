package stone_editor;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class 石头语言用词规则 extends WordRule {

  private static final ArrayList<String> 关键字 =
      new ArrayList<>(Arrays.asList("每当", "如果", "否则", "类别", "定义"));

  private static final Color 深紫红 = Display.getCurrent().getSystemColor(SWT.COLOR_DARK_MAGENTA);

  public 石头语言用词规则() {
    super(new 探测器());

    for (String 词 : 关键字) {
      addWord(词, new Token(new TextAttribute(深紫红, null, SWT.BOLD)));
    }
  }
}
