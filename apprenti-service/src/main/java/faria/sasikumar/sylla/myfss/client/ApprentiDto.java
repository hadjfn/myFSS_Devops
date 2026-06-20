package faria.sasikumar.sylla.myfss.client;

import faria.sasikumar.sylla.myfss.model.Apprenti;

public record ApprentiDto(
        Long id,
        String nom,
        String prenom,
        String programme,
        String majeure,
        Integer annee,
        boolean archived
) {
    public static ApprentiDto from(Apprenti a) {
        return new ApprentiDto(
                a.getId(),
                a.getNom(),
                a.getPrenom(),
                a.getProgramme(),
                a.getMajeure(),
                a.getAnnee(),
                a.isArchived()
        );
    }
}
