package entity;

public class Subject {

    private Long ng_id;
    private String sz_caption;
    private String sz_sections;

    public Subject(Long ng_id, String sz_caption, String sz_sections) {
        this.ng_id = ng_id;
        this.sz_caption = sz_caption;
        this.sz_sections = sz_sections;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "ng_id=" + ng_id +
                ", sz_caption='" + sz_caption + '\'' +
                ", sz_sections='" + sz_sections + '\'' +
                '}';
    }

    public Long getNg_id() {
        return ng_id;
    }

    public void setNg_id(Long ng_id) {
        this.ng_id = ng_id;
    }

    public String getSz_caption() {
        return sz_caption;
    }

    public void setSz_caption(String sz_caption) {
        this.sz_caption = sz_caption;
    }

    public String getSz_sections() {
        return sz_sections;
    }

    public void setSz_sections(String sz_sections) {
        this.sz_sections = sz_sections;
    }

    public Subject() {

    }
}
