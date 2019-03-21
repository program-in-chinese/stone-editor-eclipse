package stone_editor;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;

public class StoneHoverProvider implements ITextHover {

  @Override
  public String getHoverInfo(ITextViewer 文本视图, IRegion 悬浮位置) {
    int 偏移 = 悬浮位置.getOffset();
    IDocument 文件 = 文本视图.getDocument();
    try {
      // 仅提取当前所在行, 如要取得当前鼠标所在词, 需进一步词法分析?
      int 所在行 = 文件.getLineOfOffset(偏移);
      IRegion 行信息 = 文件.getLineInformation(所在行);
      int 行长 = 行信息.getLength();
      int 行偏移 = 行信息.getOffset();
      return 文件.get(行偏移, 行长);

    } catch (BadLocationException e) {
      e.printStackTrace();
    }
    return "";
  }

  @Override
  public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
    return new Region(offset, 0);
  }
}
