package design.patterns.creational.builder;

public class Phone {

  public static class Builder {
    private String frontPanel;
    private String backPanel;
    private String camera;
    private String processor;

    public Builder() {
    }
    public Phone build(){
      return new Phone(this);
    }

    public Builder frontPanel(String frontPanel) {
      this.frontPanel = frontPanel;
      return this;
    }

    public Builder backPanel(String backPanel) {
      this.backPanel = backPanel;
      return this;
    }

    public Builder camera(String camera) {
      this.camera = camera;
      return this;
    }

    public Builder processor(String processor) {
      this.processor = processor;
      return this;
    }
  }

  private String frontPanel;
  private String backPanel;
  private String camera;
  private String processor;

  private Phone(Builder builder) {
    this.frontPanel = builder.frontPanel;
    this.backPanel = builder.backPanel;
    this.camera = builder.camera;
    this.processor = builder.processor;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Phone{");
    sb.append("frontPanel='").append(frontPanel).append('\'');
    sb.append(", backPanel='").append(backPanel).append('\'');
    sb.append(", camera='").append(camera).append('\'');
    sb.append(", processor='").append(processor).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
