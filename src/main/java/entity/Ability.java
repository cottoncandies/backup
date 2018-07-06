package entity;

public class Ability {
    private Long ng_id;
    private Integer nt_section;
    private Long ng_subject_id;
    private String sz_caption;
    private Integer nt_state;
    private String tx_comment;
    private Integer nt_old_id;

    public Long getNg_id() {
        return ng_id;
    }

    public void setNg_id(Long ng_id) {
        this.ng_id = ng_id;
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

    public String getSz_caption() {
        return sz_caption;
    }

    public void setSz_caption(String sz_caption) {
        this.sz_caption = sz_caption;
    }

    public Integer getNt_state() {
        return nt_state;
    }

    public void setNt_state(Integer nt_state) {
        this.nt_state = nt_state;
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

    public Ability() {

    }
}
