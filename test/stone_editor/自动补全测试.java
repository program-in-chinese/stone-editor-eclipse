package stone_editor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.junit.jupiter.api.Test;

class 自动补全测试 {

  @Test
  void 获取建议() throws BadLocationException {
    内容辅助处理器 内容辅助 = new 内容辅助处理器();

    List<补全建议信息> 补全建议 = 内容辅助.获取建议(new String[] {"新建"}, "新", "新", 0, 1);
    assertEquals(1, 补全建议.size());
    assertEquals(new 补全建议信息("新建", 0, 1, 2), 补全建议.get(0));

    String 所有内容 =
        "偶 = 0\\n奇 = 0\\ni = 1\\n每当 i < 10 {\\n  如果 i % 2 == 0 { // 偶数?\\n    偶 = 偶 + i\\n  } 否则 {\\n    奇 = 奇 + i\\n  }\\n  i = i + 1\\n}\\n偶 + 奇\\n新";
    String 当前行文本 = "新";
    int 行头偏移 = 116;
    int 当前行文本长度 = 1;
    补全建议 = 内容辅助.获取建议(new String[] {"新建"}, 所有内容, 当前行文本, 行头偏移, 当前行文本长度);
    assertEquals(1, 补全建议.size());
    assertEquals(new 补全建议信息("新建", 116, 1, 2), 补全建议.get(0));
  }

}
