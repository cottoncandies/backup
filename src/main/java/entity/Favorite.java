package entity;

import java.util.Date;

public class Favorite {
    private Long ng_id;
    private Long ng_user_id;
    private Long ng_subject_id;
    private Long ng_exam_id;
    private Integer nt_section;
    private Date ts_created;

    public Long getNg_id() {
        return ng_id;
    }

    public void setNg_id(Long ng_id) {
        this.ng_id = ng_id;
    }

    public Long getNg_user_id() {
        return ng_user_id;
    }

    public void setNg_user_id(Long ng_user_id) {
        this.ng_user_id = ng_user_id;
    }

    public Long getNg_subject_id() {
        return ng_subject_id;
    }

    public void setNg_subject_id(Long ng_subject_id) {
        this.ng_subject_id = ng_subject_id;
    }

    public Long getNg_exam_id() {
        return ng_exam_id;
    }

    public void setNg_exam_id(Long ng_exam_id) {
        this.ng_exam_id = ng_exam_id;
    }

    public Integer getNt_section() {
        return nt_section;
    }

    public void setNt_section(Integer nt_section) {
        this.nt_section = nt_section;
    }

    public Date getTs_created() {
        return ts_created;
    }

    public void setTs_created(Date ts_created) {
        this.ts_created = ts_created;
    }

    public Favorite() {

    }
}
