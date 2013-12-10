package teppeistudio.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.directio.DirectFileOutputDescription;
import teppeistudio.modelgen.dmdl.model.JoinedSalesDetail;
/**
 * An abstract implementation of {@link JoinedSalesDetail} exporter description using Direct I/O CSV.
 */
public abstract class AbstractJoinedSalesDetailCsvOutputDescription extends DirectFileOutputDescription {
    @Override public Class<? extends JoinedSalesDetail> getModelType() {
        return JoinedSalesDetail.class;
    }
    @Override public Class<JoinedSalesDetailCsvFormat> getFormat() {
        return JoinedSalesDetailCsvFormat.class;
    }
}