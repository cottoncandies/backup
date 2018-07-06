package entity;

public class BookCatalog {
    private Long ng_id;
    private String sz_num;
    private String sz_parent_num;
    private String sz_caption;
    private Long ng_parent_id;
    private Integer nt_section;
    private  Long ng_subject_id;
    private Integer nt_grade;
    private Integer nt_serial;
    private  String sz_descr;
    private  Integer nt_show;
    private  String tx_comment;
    private Integer nt_old_id;

    public BookCatalog(Long ng_id, String sz_num, String sz_parent_num, String sz_caption, Long ng_parent_id, Integer nt_section, Long ng_subject_id, Integer nt_grade, Integer nt_serial, String sz_descr, Integer nt_show, String tx_comment, Integer nt_old_id) {
        this.ng_id = ng_id;
        this.sz_num = sz_num;
        this.sz_parent_num = sz_parent_num;
        this.sz_caption = sz_caption;
        this.ng_parent_id = ng_parent_id;
        this.nt_section = nt_section;
        this.ng_subject_id = ng_subject_id;
        this.nt_grade = nt_grade;
        this.nt_serial = nt_serial;
        this.sz_descr = sz_descr;
        this.nt_show = nt_show;
        this.tx_comment = tx_comment;
        this.nt_old_id = nt_old_id;
    }

    public Long getNg_id() {
        return ng_id;
    }

    public void setNg_id(Long ng_id) {
        this.ng_id = ng_id;
    }

    public String getSz_num() {
        return sz_num;
    }

    public void setSz_num(String sz_num) {
        this.sz_num = sz_num;
    }

    public String getSz_parent_num() {
        return sz_parent_num;
    }

    public void setSz_parent_num(String sz_parent_num) {
        this.sz_parent_num = sz_parent_num;
    }

    public String getSz_caption() {
        return sz_caption;
    }

    public void setSz_caption(String sz_caption) {
        this.sz_caption = sz_caption;
    }

    public Long getNg_parent_id() {
        return ng_parent_id;
    }

    public void setNg_parent_id(Long ng_parent_id) {
        this.ng_parent_id = ng_parent_id;
    }

    public Integer getNt_section() {
        return nt_section;
    }

    public void setNt_section(Integer nt_section) {
        this.nt_section = nt_section;
    }

    public Long getNg_subject_id() {
        return ng_subject_id;
    }

    public void setNg_subject_id(Long ng_subject_id) {
        this.ng_subject_id = ng_subject_id;
    }

    public Integer getNt_grade() {
        return nt_grade;
    }

    public void setNt_grade(Integer nt_grade) {
        this.nt_grade = nt_grade;
    }

    public Integer getNt_serial() {
        return nt_serial;
    }

    public void setNt_serial(Integer nt_serial) {
        this.nt_serial = nt_serial;
    }

    public String getSz_descr() {
        return sz_descr;
    }

    public void setSz_descr(String sz_descr) {
        this.sz_descr = sz_descr;
    }

    public Integer getNt_show() {
        return nt_show;
    }

    public void setNt_show(Integer nt_show) {
        this.nt_show = nt_show;
    }

    public String getTx_comment() {
        return tx_comment;
    }

    public void setTx_comment(String tx_comment) {
        this.tx_comment = tx_comment;
    }

    public Integer getNt_old_id() {
        return nt_old_id;
    }

    public void setNt_old_id(Integer nt_old_id) {
        this.nt_old_id = nt_old_id;
    }

    public BookCatalog() {

    }
}
