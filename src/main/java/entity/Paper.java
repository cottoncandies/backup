package entity;

import java.util.Date;

public class Paper {

    private Long ng_id;
    private String sz_num;
    private String sz_caption;
    private String sz_kind;
    private String sz_age;
    private Long ng_cat_id;
    private Integer nt_section;
    private Long ng_subject_id;
    private String sz_wenli;
    private String sz_prov;
    private String sz_city;
    private Integer nt_term;
    private Integer nt_grade;
    private Integer nt_score;
    private Integer nt_score_ex;
    private Integer nt_cost_resp;
    private Date ts_created;
    private Date ts_updated;
    private Date ts_auditing;
    private String tx_comment;
    private String sz_infor_src;
    private String sz_infor_kind;
    private Integer nt_old_id;

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

    public String getSz_caption() {
        return sz_caption;
    }

    public void setSz_caption(String sz_caption) {
        this.sz_caption = sz_caption;
    }

    public String getSz_kind() {
        return sz_kind;
    }

    public void setSz_kind(String sz_kind) {
        this.sz_kind = sz_kind;
    }

    public String getSz_age() {
        return sz_age;
    }

    public void setSz_age(String sz_age) {
        this.sz_age = sz_age;
    }

    public Long getNg_cat_id() {
        return ng_cat_id;
    }

    public void setNg_cat_id(Long ng_cat_id) {
        this.ng_cat_id = ng_cat_id;
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

    public String getSz_wenli() {
        return sz_wenli;
    }

    public void setSz_wenli(String sz_wenli) {
        this.sz_wenli = sz_wenli;
    }

    public String getSz_prov() {
        return sz_prov;
    }

    public void setSz_prov(String sz_prov) {
        this.sz_prov = sz_prov;
    }

    public String getSz_city() {
        return sz_city;
    }

    public void setSz_city(String sz_city) {
        this.sz_city = sz_city;
    }

    public Integer getNt_term() {
        return nt_term;
    }

    public void setNt_term(Integer nt_term) {
        this.nt_term = nt_term;
    }

    public Integer getNt_grade() {
        return nt_grade;
    }

    public void setNt_grade(Integer nt_grade) {
        this.nt_grade = nt_grade;
    }

    public Integer getNt_score() {
        return nt_score;
    }

    public void setNt_score(Integer nt_score) {
        this.nt_score = nt_score;
    }

    public Integer getNt_score_ex() {
        return nt_score_ex;
    }

    public void setNt_score_ex(Integer nt_score_ex) {
        this.nt_score_ex = nt_score_ex;
    }

    public Integer getNt_cost_resp() {
        return nt_cost_resp;
    }

    public void setNt_cost_resp(Integer nt_cost_resp) {
        this.nt_cost_resp = nt_cost_resp;
    }

    public Date getTs_created() {
        return ts_created;
    }

    public void setTs_created(Date ts_created) {
        this.ts_created = ts_created;
    }

    public Date getTs_updated() {
        return ts_updated;
    }

    public void setTs_updated(Date ts_updated) {
        this.ts_updated = ts_updated;
    }

    public Date getTs_auditing() {
        return ts_auditing;
    }

    public void setTs_auditing(Date ts_auditing) {
        this.ts_auditing = ts_auditing;
    }

    public String getTx_comment() {
        return tx_comment;
    }

    public void setTx_comment(String tx_comment) {
        this.tx_comment = tx_comment;
    }

    public String getSz_infor_src() {
        return sz_infor_src;
    }

    public void setSz_infor_src(String sz_infor_src) {
        this.sz_infor_src = sz_infor_src;
    }

    public String getSz_infor_kind() {
        return sz_infor_kind;
    }

    public void setSz_infor_kind(String sz_infor_kind) {
        this.sz_infor_kind = sz_infor_kind;
    }

    public Integer getNt_old_id() {
        return nt_old_id;
    }

    public void setNt_old_id(Integer nt_old_id) {
        this.nt_old_id = nt_old_id;
    }

    public Paper() {

    }
}
