package teppeistudio.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.directio.DirectFileInputDescription;
import teppeistudio.modelgen.dmdl.model.JoinedSalesDetail;
/**
 * An abstract implementation of {@link JoinedSalesDetail} importer description using Direct I/O CSV.
 */
public abstract class AbstractJoinedSalesDetailCsvInputDescription extends DirectFileInputDescription {
    @Override public Class<? extends JoinedSalesDetail> getModelType() {
        return JoinedSalesDetail.class;
    }
    @Override public Class<JoinedSalesDetailCsvFormat> getFormat() {
        return JoinedSalesDetailCsvFormat.class;
    }
}