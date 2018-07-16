package entity;

public class user {
    private Long ng_id;
    private String sz_username;
    private String sz_password;
    private Integer nt_section;
    private Long ng_subject_id;
    private String sz_nickname;

    public Long getNg_id() {
        return ng_id;
    }

    public void setNg_id(Long ng_id) {
        this.ng_id = ng_id;
    }

    public String getSz_username() {
        return sz_username;
    }

    public void setSz_username(String sz_username) {
        this.sz_username = sz_username;
    }

    public String getSz_password() {
        return sz_password;
    }

    public void setSz_password(String sz_password) {
        this.sz_password = sz_password;
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

    public String getSz_nickname() {
        return sz_nickname;
    }

    public void setSz_nickname(String sz_nickname) {
        this.sz_nickname = sz_nickname;
    }

    public user() {

    }
}
