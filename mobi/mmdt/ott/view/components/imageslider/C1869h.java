package mobi.mmdt.ott.view.components.imageslider;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.h */
public enum C1869h {
    Default("Default"),
    Accordion("Accordion"),
    Background2Foreground("Background2Foreground"),
    CubeIn("CubeIn"),
    DepthPage("DepthPage"),
    Fade("Fade"),
    FlipHorizontal("FlipHorizontal"),
    FlipPage("FlipPage"),
    Foreground2Background("Foreground2Background"),
    RotateDown("RotateDown"),
    RotateUp("RotateUp"),
    Stack("Stack"),
    Tablet("Tablet"),
    ZoomIn("ZoomIn"),
    ZoomOutSlide("ZoomOutSlide"),
    ZoomOut("ZoomOut");
    
    private final String f6015q;

    private C1869h(String str) {
        this.f6015q = str;
    }

    public boolean m8991a(String str) {
        return str != null && this.f6015q.equals(str);
    }

    public String toString() {
        return this.f6015q;
    }
}
