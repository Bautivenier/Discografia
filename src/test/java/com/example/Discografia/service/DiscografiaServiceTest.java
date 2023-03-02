package com.example.Discografia.service;

import com.example.Discografia.exeption.DiscografiaNotFoundException;
import com.example.Discografia.model.Discografia;
import com.example.Discografia.repository.DiscografiaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class DiscografiaServiceTest {

        @Mock
        private DiscografiaRepository discografiaRepository;
        private DiscografiaService testedDiscografiaService;

        @BeforeEach
        void setUp(){
            System.out.println("Esto Se ejecuta antes de cadatest");
            testedDiscografiaService = new DiscografiaService(discografiaRepository);

        }
        @Test
        void findAllDiscografiaTest() {
            testedDiscografiaService.findAllDiscografia();
            verify(discografiaRepository).findAll();

        }
        @Test
        void addDiscografiaTest(){
            Discografia discografia = new Discografia( 7L, "Nirvana", "Nevermind", "1991" , "DGC Records", "kurt cobain", "DGC Records", "nevermind");
            when(discografiaRepository.save(any(Discografia.class))).thenReturn(discografia);
            assertNotNull(testedDiscografiaService.addDiscografia(new Discografia()));
        }

        @Test
        void findDiscografiaByIdTest(){
            Long discografiaId = 7L;
            Discografia mockedDiscografia = new Discografia(discografiaId, "Nirvana", "Nevermind", "1991", "DGC", "kurt cobain", "DGC Records", "nevermind");
            doReturn(Optional.of(mockedDiscografia)).when(discografiaRepository).findById(discografiaId);
            // Make the service call
            Discografia discografiaByService = testedDiscografiaService.findDiscografiaByid(discografiaId);
            // Assert the response
            assertNotNull(discografiaByService,"Employye with employeeId : "+discografiaId+" not found");
            assertEquals(discografiaId, discografiaByService.getId());
            assertEquals(mockedDiscografia.getArtista(), discografiaByService.getArtista());
            assertEquals(mockedDiscografia.getDisco(), discografiaByService.getDisco());
            assertEquals(mockedDiscografia.getFecha(), discografiaByService.getFecha());
            assertEquals(mockedDiscografia.getDiscografica(), discografiaByService.getDiscografica());
            assertEquals(mockedDiscografia.getProductores(), discografiaByService.getProductores());
            assertEquals(mockedDiscografia.getEstudio(), discografiaByService.getEstudio());
            assertEquals(mockedDiscografia.getPortada(), discografiaByService.getPortada());

        }

        @Test
        void findDiscografiaByIdFailedTest(){
            Long wrongDiscografiaId = 7L;
            Exception exception = assertThrows(DiscografiaNotFoundException.class, () -> {
                testedDiscografiaService.findDiscografiaByid(wrongDiscografiaId);

            });

            String expectedMessage = "could not find discografia with id: "+ wrongDiscografiaId;
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));

        }

}


