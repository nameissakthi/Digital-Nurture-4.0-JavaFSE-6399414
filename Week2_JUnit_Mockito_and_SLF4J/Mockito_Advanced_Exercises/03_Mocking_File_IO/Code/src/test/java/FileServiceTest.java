import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FileServiceTest {

    @Test
    public void testServiceWithMockFileIO() {
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);
        when(mockFileReader.read()).thenReturn("Mock File Content");
        FileService fileService = new FileService(mockFileReader, mockFileWriter);
        String result = fileService.processFile();
        assertEquals("Processed Mock File Content", result);
        verify(mockFileWriter).write("Processed Mock File Content");
    }
}