package InputOutput;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class AudioOutput extends Output
{
	private static final long serialVersionUID = 1L;
	private static Voice voice_ = VoiceManager.getInstance().getVoice("kevin16");

	public AudioOutput()
	{
		voice_.allocate();
	}
	
	@Override
	public void putString(String output)
	{
		voice_.speak(output);
	}

	@Override
	public void close()
	{
		voice_.deallocate();
	}

}
