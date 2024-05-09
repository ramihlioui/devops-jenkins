package tn.esprit.rh.achat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class FournisseurServiceTest {

    @Mock
    private FournisseurRepository fournisseurRepository;
    @Mock
    private DetailFournisseurRepository detailFournisseurRepository;
    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    private Fournisseur fournisseur;

    @BeforeEach
    public void setUp() {
        fournisseur = new Fournisseur(1L, "code", "libelle", CategorieFournisseur.ORDINAIRE, null, null, null);
    }

    @Test
    public void testRetrieveAllFournisseurs() {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        fournisseurs.add(fournisseur);

        when(fournisseurRepository.findAll()).thenReturn(fournisseurs);
        List<Fournisseur> result = fournisseurService.retrieveAllFournisseurs();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo(fournisseur);
    }

    @Test
    public void testRetrieveFournisseur() {
        when(fournisseurRepository.findById(1L)).thenReturn(Optional.of(fournisseur));
        Fournisseur result = fournisseurService.retrieveFournisseur(1L);
        assertThat(result).isEqualTo(fournisseur);
    }

    @Test
    public void testAddFournisseur() {
        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);
        Fournisseur result = fournisseurService.addFournisseur(fournisseur);
        assertThat(result).isEqualTo(fournisseur);
    }

    @Test
    public void testDeleteFournisseur() {
        fournisseurService.deleteFournisseur(1L);
        verify(fournisseurRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateFournisseur() {
        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);
        Fournisseur result = fournisseurService.updateFournisseur(fournisseur);
        assertThat(result).isEqualTo(fournisseur);
    }

}