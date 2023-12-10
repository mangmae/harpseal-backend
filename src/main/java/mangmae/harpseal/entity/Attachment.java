package mangmae.harpseal.entity;

import jakarta.persistence.*;
import mangmae.harpseal.entity.type.AttachmentType;

@Entity
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachment_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Enumerated(EnumType.STRING)
    private AttachmentType attachmentType;
    private String filePath;
}