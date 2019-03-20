package stone_editor;

import org.eclipse.jface.text.rules.IWordDetector;

public class 探测器 implements IWordDetector {
  @Override
  public boolean isWordStart(char c) {
    return Character.isAlphabetic(c);
  }

  @Override
  public boolean isWordPart(char c) {
    return Character.isAlphabetic(c);
  }
}
