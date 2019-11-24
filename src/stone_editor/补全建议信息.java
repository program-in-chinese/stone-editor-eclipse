package stone_editor;

public class 补全建议信息 {
  String 取代文本;
  int 取代偏移;
  int 取代长度;
  int 光标位置;

  public 补全建议信息(String 取代文本, int 取代偏移, int 取代长度, int 光标位置) {
    this.取代文本 = 取代文本;
    this.取代偏移 = 取代偏移;
    this.取代长度 = 取代长度;
    this.光标位置 = 光标位置;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof 补全建议信息) {
      补全建议信息 对比 = (补全建议信息)obj;
      return this.取代文本 == 对比.取代文本
          && this.取代偏移 == 对比.取代偏移
          && this.取代长度 == 对比.取代长度
          && this.光标位置 == 对比.光标位置;
    }
    return false;
  }

}
