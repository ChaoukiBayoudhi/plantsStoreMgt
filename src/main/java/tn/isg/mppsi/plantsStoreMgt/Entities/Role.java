package tn.isg.mppsi.plantsStoreMgt.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Role {
    @Id @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    @NonNull
    private RoleType name;
}
