package stone_editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class 内容辅助处理器 implements IContentAssistProcessor {

  public static final String[] 所有建议 = new String[] {"新建"};

  @Override
  public ICompletionProposal[] computeCompletionProposals(ITextViewer 视图, int 偏移) {

    IDocument 文件 = 视图.getDocument();

    try {
      int 偏移所在行 = 文件.getLineOfOffset(偏移);
      int 行头偏移 = 文件.getLineOffset(偏移所在行);

      int 当前行文本长度 = 偏移 - 行头偏移;
      String 当前行文本 = 文件.get(行头偏移, 当前行文本长度).toLowerCase();
      String 所有内容 = 文件.get();

      List<补全建议信息> 建议信息 = 获取建议(所有建议, 所有内容, 当前行文本, 行头偏移, 当前行文本长度);
      return 建议信息.stream()
          .map(信息 -> new CompletionProposal(信息.取代文本, 信息.取代偏移, 信息.取代长度, 信息.光标位置))
          .toArray(ICompletionProposal[]::new);
    } catch (BadLocationException e) {
      e.printStackTrace();
    }
    return new ICompletionProposal[0];
  }

  protected List<补全建议信息> 获取建议(String[] 备选建议, String 所有内容, String 当前行文本, int 行头偏移, int 当前行文本长度)
      throws BadLocationException {
    List<补全建议信息> 建议信息 = new ArrayList<>();
    for (String 建议: Arrays.asList(备选建议)) {
      if (!所有内容.contains(建议) && 建议.toLowerCase().startsWith(当前行文本)) {
        建议信息.add(new 补全建议信息(建议, 行头偏移, 当前行文本长度, 建议.length()));
      }
    }
    return 建议信息;
  }

  @Override
  public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
    return null;
  }

  @Override
  public char[] getCompletionProposalAutoActivationCharacters() {
    String keys = "新";
    return keys.toCharArray();
  }

  @Override
  public char[] getContextInformationAutoActivationCharacters() {
    String keys = "";
    return keys.toCharArray();
  }

  @Override
  public String getErrorMessage() {
    return null;
  }

  @Override
  public IContextInformationValidator getContextInformationValidator() {
    return null;
  }

}
