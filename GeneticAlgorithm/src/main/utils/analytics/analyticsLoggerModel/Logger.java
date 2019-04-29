package main.utils.analytics.analyticsLoggerModel;

import main.utils.analytics.analyticsDataModel.CurrentInformationData;
import main.utils.analytics.analyticsDataModel.ProblemConfigurationData;
import main.utils.io.file.*;
import main.utils.io.folder.Folder;
import main.utils.io.folder.FolderNamesList;

public class Logger {
    private CurrentInformationFile informationFile;
    private ProblemConfigurationFile  configFile;
    private int executionNumber;

    public Logger(int executionNumber) {
        this.executionNumber = executionNumber;

        if (!Folder.isFolderAlreadyCreated(FolderNamesList.ROOT_PATH))
            Folder.createFolder(FolderNamesList.ROOT_PATH);

        String executionFolder = FolderNamesList.ROOT_PATH + "\\" + this.executionNumber;
        if (!Folder.isFolderAlreadyCreated(executionFolder))
            Folder.createFolder(executionFolder);

        String extension = FileExtensionsList.TXT;
        configFile = new ProblemConfigurationFile(executionNumber + "\\" + FileNamesList.MAIN_LOG, extension);
    }

    public void log (CurrentInformationData data) {
        String infoFileName = FileNamesList.CURRENT_EPOCH_INFORMATION ;

        String extension = FileExtensionsList.CSV;

        informationFile = new CurrentInformationFile(executionNumber + "\\" + infoFileName, extension);

        informationFile.setData(data);

        informationFile.createFile();
    }

    public void initialLog(ProblemConfigurationData data) {
        this.configFile.setData(data);
        this.configFile.createFile();
    }

}
