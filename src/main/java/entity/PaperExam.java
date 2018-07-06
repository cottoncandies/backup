package entity;

public class PaperExam {
    private Long ng_id;
    private Long ng_paper_id;
    private Long ng_exam_id;
    private Integer nt_index;
    private Integer nt_old_id;
    private String sz_kind;
    private String tx_comment;

    public Long getNg_id() {
        return ng_id;
    }

    public void setNg_id(Long ng_id) {
        this.ng_id = ng_id;
    }

    public Long getNg_paper_id() {
        return ng_paper_id;
    }

    public void setNg_paper_id(Long ng_paper_id) {
        this.ng_paper_id = ng_paper_id;
    }

    public Long getNg_exam_id() {
        return ng_exam_id;
    }

    public void setNg_exam_id(Long ng_exam_id) {
        this.ng_exam_id = ng_exam_id;
    }

    public Integer getNt_index() {
        return nt_index;
    }

    public void setNt_index(Integer nt_index) {
        this.nt_index = nt_index;
    }

    public Integer getNt_old_id() {
        return nt_old_id;
    }

    public void setNt_old_id(Integer nt_old_id) {
        this.nt_old_id = nt_old_id;
    }

    public String getSz_kind() {
        return sz_kind;
    }

    public void setSz_kind(String sz_kind) {
        this.sz_kind = sz_kind;
    }

    public String getTx_comment() {
        return tx_comment;
    }

    public void setTx_comment(String tx_comment) {
        this.tx_comment = tx_comment;
    }

    public PaperExam() {

    }
}
