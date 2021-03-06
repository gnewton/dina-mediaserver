package se.nrm.mediaserver.media3.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ingimar
 */
@Entity(name = "MEDIA_TEXT")
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlRootElement
public class MediaText implements Serializable {

    @Transient
    public static final String DEFAULT_LANGUAGE = "sv_SE";

    private static final long serialVersionUID = 83434343L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UUID")
    private Integer uuid;

    @Size(max = 255)
    @Column(name = "LEGEND")
    private String legend;

    @Size(max = 255)
    @Column(name = "LANG")
    private String lang;

    /**
     * Naturforskaren-specific
     */
    @Size(max = 255)
    @Column(name = "COMMENT")
    private String comment;

    @JoinColumn(name = "MEDIA_UUID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @XmlTransient
    private Media media;

    public MediaText() {
    }

    public MediaText(String legend, String lang) {
        this.legend = legend;
        this.setLang(lang);
    }
    public MediaText(String legend, String lang,String comment) {
        this.legend = legend;
        this.comment = comment;
        this.setLang(lang);
    }

    public MediaText(String legend, String lang, Media media) {
        this.legend = legend;
        this.media = media;
        this.setLang(lang);
    }

    public MediaText(String legend, String lang, Media media, String comment) {
        this.legend     = legend;
        this.comment    = comment;
        this.media      = media;
        this.setLang(lang);
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        if (null == lang || lang.equals("")) {
            lang = MediaText.DEFAULT_LANGUAGE;
        }

        this.lang = lang;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append('{');
        sb.append("MediaText:");
        sb.append(", uuid='").append(uuid).append('\'');
        sb.append(", legend='").append(legend).append('\'');
        sb.append(", lang='").append(lang).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
