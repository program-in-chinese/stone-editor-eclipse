package stone_editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.NumberRule;
import org.eclipse.jface.text.rules.PatternRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

public class StoneReconciler extends PresentationReconciler {
  Token 深红 = 字号(SWT.COLOR_DARK_RED);
  Token 深绿 = 字号(SWT.COLOR_DARK_GREEN);
  Token 蓝色 = 字号(SWT.COLOR_BLUE);

  public StoneReconciler() {
    RuleBasedScanner 扫描器 = new RuleBasedScanner();
    SingleLineRule 单引号 = new SingleLineRule("'", "'", 深红);
    SingleLineRule 双引号 = new SingleLineRule("\"", "\"", 深红);
    NumberRule 数字 = new NumberRule(蓝色);
    石头语言用词规则 用词规则 = new 石头语言用词规则();
    PatternRule 模式规则 = new PatternRule("//", null, 深绿, (char) 0, true);
    扫描器.setRules(new IRule[] {单引号, 双引号, 用词规则, 模式规则, 数字});
    DefaultDamagerRepairer 修理器 = new DefaultDamagerRepairer(扫描器);
    this.setDamager(修理器, IDocument.DEFAULT_CONTENT_TYPE);
    this.setRepairer(修理器, IDocument.DEFAULT_CONTENT_TYPE);
  }

  private Token 字号(int 色号) {
    return new Token(new TextAttribute(Display.getCurrent().getSystemColor(色号)));
  }
}
