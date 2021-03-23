package gr.kwtsos;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

public class MultiplierBolt extends BaseBasicBolt{
    static final long serialVersionUID = 1;

    @Override
    public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        Integer number = tuple.getInteger(0);
        number*=2;
        basicOutputCollector.emit(new Values(number));
        System.out.println(number);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("field"));
    }
}